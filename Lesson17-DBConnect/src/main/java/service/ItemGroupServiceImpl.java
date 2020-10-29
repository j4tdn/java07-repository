package service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import DTO.ItemGroupDetailDTO;
import DTO.ItemGroupDetailRawData;
import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import entity.ItemGroup;

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
	public List<ItemGroup> getName(String name) {
		if (name == null) {
			throw new RuntimeException("Property cann't be NULL!");
		}
		return itemGroupDao.getName(name);
	}

	@Override
	public ItemGroup getId(int id) {
		return itemGroupDao.getId(id);
	}

	@Override
	public List<ItemGroupDetailDTO> getItemGroupDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	

}