package controller;

import java.util.List;

import entities.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class ItemGroupControllerImpl implements ItemGroupController{
	
	private ItemGroupService itemGroupService;
	
	public ItemGroupControllerImpl() {
		itemGroupService = new ItemGroupServiceImpl();
	}

	public List<ItemGroup> getAll() {
		return itemGroupService.getAll();
	}

	public List<ItemGroup> get(String name) {
		if (name != null) {
			throw new IllegalArgumentException("name cannot null");
		}
		return itemGroupService.get(name);
	}

	public ItemGroup get(int id) {
		return itemGroupService.get(id);
	}
	
}
