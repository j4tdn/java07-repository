package controller;

import java.util.List;

import dto.ItemGroupDetailDto;
import entities.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;


public class ItemGroupControllerImpl implements ItemGroupController {
	private final ItemGroupService service;
	
	public ItemGroupControllerImpl() {
		service = new ItemGroupServiceImpl();
	}
	
	@Override
	public List<ItemGroup> getAll() {
		
		return service.getAll();
	}

	@Override
	public ItemGroup get(int id) {
		return service.get(id);
	}

	@Override
	public List<ItemGroup> get(String name) {
		if(name==null) {
			throw new IllegalArgumentException("property cannot ");
		}
		return service.get(name);
	}

	@Override
	public List<ItemGroupDetailDto> getItemGroupDetails() {
		return service.getItemGroupDetails();
	}

}
