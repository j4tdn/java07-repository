package dao;

import java.util.List;

import entities.ItemGroup;

public interface ItemGroupDao {
	List<ItemGroup> getAll();
	List<ItemGroup> get(String name);
	ItemGroup get(Integer id);
}
