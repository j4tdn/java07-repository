package dao;

import java.util.List;

import DTO.ItemGroupDetailDTO;
import DTO.ItemGroupDetailRawData;
import entity.ItemGroup;

public interface ItemGroupDao {
	List<ItemGroup> getAll();

	List<ItemGroup> getName(String name);

	ItemGroup getId(int id);
	
	List<ItemGroupDetailRawData> getItemGroupDetails();
}