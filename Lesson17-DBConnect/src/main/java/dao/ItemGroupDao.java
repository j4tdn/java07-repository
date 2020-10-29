package dao;

import java.util.List;

import dto.ItemGroupDetailDto;
import entities.ItemGroup;

public interface ItemGroupDao {
List<ItemGroup> getAll();
List<ItemGroupDetailDto> getItemGroupDetails();
}
