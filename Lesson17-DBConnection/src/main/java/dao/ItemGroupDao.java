package dao;

import java.util.List;

import dto.ItemGroupDetailRawData;
import entities.ItemGroup;

public interface ItemGroupDao {
	/*
	 * get all itemGroup
	 */
	List<ItemGroup> getAll();
	
	List<ItemGroup> get(String name);
	List<ItemGroupDetailRawData> getItemGroupDetails();
	
	ItemGroup get(int id);

}
