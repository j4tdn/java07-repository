package service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import entities.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService{
	private final ItemGroupDao itemGroupDao;
	
	public ItemGroupServiceImpl() {
		itemGroupDao = new ItemGroupDaoImpl();
	}

	@Override
	public List<ItemGroup> getAll() {
		return Optional.of(itemGroupDao.getAll())
				.orElse(Collections.emptyList());
	}

	@Override
	public ItemGroup getById(int id) {
		return itemGroupDao.getById(id);
	}

	@Override
	public List<ItemGroup> getByName(String name) {
		if (name == null) {
			throw new RuntimeException("Property cannot be null");
		}
		return Optional.of(itemGroupDao.getByName(name))
				.orElse(Collections.emptyList());
	}

}
