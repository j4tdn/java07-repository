package view;

import java.util.List; 
import controller.ItemGroupController;
import controller.ItemGroupControllerImpl;
import dto.ItemGroupDetailDto;
import entities.ItemGroup;

public class ItemGroupView {
	private static ItemGroupController itemGroupController;
	static {
		itemGroupController = new ItemGroupControllerImpl();
	}

	public static void main(String[] args) {
		List<ItemGroup> itemGroups = itemGroupController.getAll();
		itemGroups.forEach(System.out::println);

		System.out.println("================");
		// get by name
		List<ItemGroup> itemGroupsByName = itemGroupController.get("Áo");
		itemGroupsByName.forEach(System.out::println);

		System.out.println("================");
		// get by id
		ItemGroup itemGroupById = itemGroupController.get(2);
		System.out.println(itemGroupById);
		
		System.out.println("================");
		// using dto
		// entities: 1 bang, dto: nhieu bang
		List<ItemGroupDetailDto> result=itemGroupController.getItemGroupDetails();
		System.out.println(result);
	}
}
