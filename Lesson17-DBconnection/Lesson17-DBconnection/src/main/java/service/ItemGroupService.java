package service;

import java.util.List;

import ItemGroupDetailRawData.ItemGroupDetailDto;
import entities.ItemGroup;

public interface ItemGroupService {
	List<ItemGroup> getAll();

	ItemGroup get(int id);

	List<ItemGroup> get(String name);
	
	List<ItemGroupDetailDto> getItemGroupDetail();
}
