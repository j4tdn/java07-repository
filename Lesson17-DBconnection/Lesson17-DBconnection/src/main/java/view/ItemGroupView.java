package view;

import java.util.List;

import ItemGroupDetailRawData.ItemGroupDetailDto;
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
		System.out.println("================");
		ItemGroup itemGroupById = itemGroupController.get(1);
		System.out.println(itemGroupById);

		// 3. Get item group by name
		System.out.println("================");
		List<ItemGroup> itemGroupsByName = itemGroupController.get("dép");
		itemGroupsByName.forEach(System.out::println);
		
		// 3. Get item group by name
		System.out.println("================");
		List<ItemGroupDetailDto> res = itemGroupController.getItemGroupDetail();
		System.out.println(res);
	}
}
