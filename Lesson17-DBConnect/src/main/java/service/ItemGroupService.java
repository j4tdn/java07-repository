package service;

import java.util.List;

import dto.ItemGroupDetailDto;
import entity.ItemGroup;

public interface ItemGroupService {
	List<ItemGroup> getAll();

	List<ItemGroup> getName(String name);

	ItemGroup getId(int id);

	List<ItemGroupDetailDto> getGroupDetailDtos();
}