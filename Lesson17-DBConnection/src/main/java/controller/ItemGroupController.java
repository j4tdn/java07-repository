package controller;

import java.util.List;

import entities.ItemGroup;

public interface ItemGroupController {
	List<ItemGroup> getAll();
	List<ItemGroup> get(String name);
	
	ItemGroup get(int id);

}