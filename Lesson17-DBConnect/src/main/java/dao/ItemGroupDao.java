package dao;

import java.util.List;

import dto.ItemGroupDetailRawDto;
import entity.ItemGroup;

public interface ItemGroupDao {
	List<ItemGroup> getAll();

	List<ItemGroup> getName(String name);

	ItemGroup getId(int id);

	List<ItemGroupDetailRawDto> getItemGroupDetailRawDto();
}