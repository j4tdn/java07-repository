package service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import entities.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService{
	
	private final ItemGroupDao itemgroupdao;
	
	public ItemGroupServiceImpl() {
		itemgroupdao = new ItemGroupDaoImpl();
	}

	@Override
	public List<ItemGroup> getAll() {
		return Optional.ofNullable(itemgroupdao.getAll()).orElse(Collections.emptyList());
	}
	
	@Override
	public List<ItemGroup> get(String name) {
		if (name == null ) {
			throw new RuntimeException("Name can't null");
		}
		return Optional.ofNullable(itemgroupdao.getAll()).orElse(Collections.emptyList());
	}
	
	@Override
	public ItemGroup get(int id) {
		return itemgroupdao.get(id);
	}

}
