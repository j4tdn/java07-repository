package controller;

import java.util.List;

import entities.ItemGroup;

public interface ItemGroupController {
	List<ItemGroup> getAll();
	ItemGroup getById(int id);
	List<ItemGroup> getByName(String name);
}
