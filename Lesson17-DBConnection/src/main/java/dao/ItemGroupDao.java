package dao;

import java.util.List;

import dto.ItemGroupDetailRawData;
import entities.ItemGroup;

public interface ItemGroupDao {
	List<ItemGroup> getAll();

	ItemGroup get(int id);

	List<ItemGroup> get(String name);

	List<ItemGroupDetailRawData> getItemGroupDetails();
}
