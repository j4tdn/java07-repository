package dao;

import java.util.List;

import dto.ItemGroupDetailRawData;
import entities.ItemGroup;

public interface ItemGroupDao {
	List<ItemGroup> getAll();
	ItemGroup getById(int id);
	List<ItemGroup> getByName(String name);
	List<ItemGroupDetailRawData> getItemGroupDetail();
}
