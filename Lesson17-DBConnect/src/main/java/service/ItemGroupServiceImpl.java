package service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import controller.ItemGroupController;
import controller.ItemGroupControllerImpl;
import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import dto.ItemGroupDetailDto;
import dto.ItemGroupDetailRawData;
import entities.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService {
	private final ItemGroupDao itemGroupDao;
	
	public ItemGroupServiceImpl() {
		itemGroupDao = new ItemGroupDaoImpl();
	}
	@Override
	public List<ItemGroup> getAll() {
	return 	Optional.ofNullable(itemGroupDao.getAll()).orElse(Collections.emptyList());
		

	}
	@Override
	public ItemGroup get(int id) {
		return itemGroupDao.get(id);
	}
	@Override
	public List<ItemGroup> get(String name) {
		if(name == null) {
			throw new RuntimeException("cannot be null");
		}
		return Optional.ofNullable(itemGroupDao.get(name)).orElse(Collections.emptyList());
	}
	@Override
	public List<ItemGroupDetailDto> getItemGroupDetails() {
		List<ItemGroupDetailRawData> rawData = itemGroupDao.getItemGroupDetails();
		if(rawData.isEmpty()) {
			return Collections.emptyList();
		}
		return rawData.stream().map(ItemGroupDetailDto::new).collect(Collectors.toList());
	}
	
}
