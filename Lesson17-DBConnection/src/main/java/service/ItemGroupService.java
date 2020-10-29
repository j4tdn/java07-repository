package service;

import java.util.List;

import dto.ItemGroupDetailDto;
import entities.ItemGroup;

public interface ItemGroupService {
	List<ItemGroup> getAll();
	List<ItemGroup> get(String name);
	List<ItemGroupDetailDto> getItemGroupDetails();
	ItemGroup get(int id);
}
