package controller;

import java.util.List;

import entities.ItemGroup;

public interface ItemGroupController {
	List<ItemGroup> getAll();
	ItemGroup get(int id);

	List<ItemGroup> get(String name);
}
