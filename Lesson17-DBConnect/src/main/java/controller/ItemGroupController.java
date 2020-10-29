package controller;

import java.util.List;

import DTO.ItemGroupDetailDTO;
import entity.ItemGroup;

public interface ItemGroupController {
	List<ItemGroup> getAll();

	List<ItemGroup> getName(String name);

	ItemGroup getId(int id);

	List<ItemGroupDetailDTO> getItemGroupDetails();
}