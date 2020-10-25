package controller;

import java.sql.Statement;
import java.util.List;

import entities.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class ItemGroupControllerImpl implements ItemGroupController{
	
	private ItemGroupService itemGroupService;
	
	public ItemGroupControllerImpl() {
		itemGroupService = new ItemGroupServiceImpl();
	}
	
	@Override
	public List<ItemGroup> getAll() {
		return itemGroupService.getAll();
	}

	@Override
	public ItemGroup getById(int id) {
		return itemGroupService.getById(id);
	}

	@Override
	public List<ItemGroup> getByName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Property cannot be null");
		}
		return itemGroupService.getByName(name);
	}

}
