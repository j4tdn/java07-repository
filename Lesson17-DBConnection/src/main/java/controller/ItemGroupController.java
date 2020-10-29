package controller;

import java.util.List;

import dto.ItemGroupDetailDto;
import entities.ItemGroup;

public interface ItemGroupController {
	List<ItemGroup> getAll();

	List<ItemGroup> get(String name);
	
	List<ItemGroupDetailDto> getItemGroupDetails();
	
	ItemGroup get(int id);
}
