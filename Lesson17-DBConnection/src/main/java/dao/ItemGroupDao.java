package dao;

import java.util.List;

import entities.ItemGroup;

public interface ItemGroupDao {
	/*
	 * get all itemGroup
	 */
	List<ItemGroup> getAll();
	
	List<ItemGroup> get(String name);
	
	ItemGroup get(int id);

}
