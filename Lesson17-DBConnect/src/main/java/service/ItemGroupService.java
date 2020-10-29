package service;

import java.util.List;

import DTO.ItemGroupDetailDTO;
import entity.ItemGroup;

public interface ItemGroupService {
	List<ItemGroup> getAll();

	List<ItemGroup> getName(String name);

	ItemGroup getId(int id);

	List<ItemGroupDetailDTO> getItemGroupDetails();
	
	
}