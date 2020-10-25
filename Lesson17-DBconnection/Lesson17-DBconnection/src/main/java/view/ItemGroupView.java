package view;

import java.util.List;

import controller.ItemGroupController;
import controller.ItemGroupControllerImpl;
import entities.ItemGroup;

public class ItemGroupView {
	
	private static ItemGroupController itemGroupController;
	
	static {
		itemGroupController = new ItemGroupControllerImpl();
	}
	
	public static void main(String[] args) {
		//1. get all item groups
		List<ItemGroup> itemGroups = itemGroupController.getAll();
		itemGroups.forEach(System.out::println);
		
		
		//2. get item group by name
		List<ItemGroup> itemGroupByName = itemGroupController.get("Mũ");
		itemGroupByName.forEach(System.out::println);
		
		
		//1. get item group by id
		ItemGroup itemGroupById = itemGroupController.get(1);
		System.out.println(itemGroupById);
	}

}
