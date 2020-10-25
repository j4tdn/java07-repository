package controller;

import java.util.List;

import entities.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class ItemGroupControllerImpl implements ItemGroupController{
	private ItemGroupService itemGroupService;
	
	public  ItemGroupControllerImpl() {
		itemGroupService = new ItemGroupServiceImpl();
	}

	@Override
	public List<ItemGroup> getAll() {
		
		return itemGroupService.getAll();
	}

	@Override
	public List<ItemGroup> get(String name) {
		if(name == null) {
			throw new IllegalArgumentException("Property cannot be null");
		}
		return itemGroupService.get(name);
	}

	@Override
	public ItemGroup get(int id) {
		// TODO Auto-generated method stub
		return itemGroupService.get(id);
	}

}
