package service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import entities.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService {
	private final ItemGroupDao itemGroupDao;

	public ItemGroupServiceImpl() {
		itemGroupDao = new ItemGroupDaoImpl();
	}

	@Override
	public List<ItemGroup> getAll() {
		return Optional.ofNullable(itemGroupDao.getAll()).orElse(Collections.emptyList());
	}

	@Override
	public List<ItemGroup> get(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Property cannot be null");
		}
		return Optional.ofNullable(itemGroupDao.get(name)).orElse(Collections.emptyList());
	}

	@Override
	public ItemGroup get(int id) {
		return itemGroupDao.get(id);
	}
}
