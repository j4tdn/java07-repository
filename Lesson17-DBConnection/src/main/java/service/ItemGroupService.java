package service;

import java.util.List;

import dto.ItemGroupDetailDTO;
import entities.ItemGroup;

public interface ItemGroupService {
	List<ItemGroup> getAll();

	ItemGroup get(int id);

	List<ItemGroupDetailDTO> getItemGroupDetails();
	List<ItemGroup> get(String name);
}
