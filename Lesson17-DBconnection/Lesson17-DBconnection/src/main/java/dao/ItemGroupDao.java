package dao;

import java.util.List;

import ItemGroupDetailRawData.ItemGroupDetailDto;
import entities.ItemGroup;

public interface ItemGroupDao {
	List<ItemGroup> getAll();

	ItemGroup get(int id);
	
	List<ItemGroupDetailDto> getItemGroupDetails();

	List<ItemGroup> get(String name);
}
