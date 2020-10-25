package controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import entity.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class ItemGroupControllerImpl implements ItemGroupController {
	private final ItemGroupService itemGroupService;

	public ItemGroupControllerImpl() {
		itemGroupService = new ItemGroupServiceImpl();
	}

	@Override
	public List<ItemGroup> getAll() {
		return Optional.ofNullable(itemGroupService.getAll()).orElse(Collections.emptyList());
	}

	@Override
	public List<ItemGroup> getName(String name) {
		if (name == null) {
			throw new RuntimeException("Property cann't be NULL!");
		}
		return itemGroupService.getName(name);
	}

	@Override
	public ItemGroup getId(int id) {
		return itemGroupService.getId(id);
	}
}