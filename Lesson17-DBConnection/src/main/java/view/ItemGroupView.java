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
		// 1. Get all items groups
		List<ItemGroup> itemGroups = itemGroupController.getAll();
		itemGroups.forEach(System.out::println);

		// 2. Get item group by id
		ItemGroup itemGroupById = itemGroupController.get(1);
		System.out.println(itemGroupById);

		// 3. Get item group by name
		List<ItemGroup> itemGroupsByName = itemGroupController.get("Mũ");
		itemGroupsByName.forEach(System.out::println);
	}
}
