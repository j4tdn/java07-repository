package controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import entities.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class ItemGroupControllerImpl implements ItemGroupController {
	private ItemGroupService itemGroupService;
	public ItemGroupControllerImpl() {
		itemGroupService=new ItemGroupServiceImpl();
	}
	@Override
	public List<ItemGroup> getAll() {
		return  Optional.ofNullable(itemGroupService.getAll()).orElse(Collections.emptyList());
	}

}
