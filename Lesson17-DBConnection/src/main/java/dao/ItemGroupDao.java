package dao;

import java.util.List;

import entities.ItemGroup;

public interface ItemGroupDao {
	List<ItemGroup> getAll();
	ItemGroup getById(int id);
	List<ItemGroup> getByName(String name);
}
