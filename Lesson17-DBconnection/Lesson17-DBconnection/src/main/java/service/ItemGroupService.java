package service;

import java.util.List;

import entities.ItemGroup;

public interface ItemGroupService {
	List<ItemGroup> getAll();
	List<ItemGroup> get(String name);
	ItemGroup get(int id);
}
