package view;

import java.util.List;

import DTO.ItemGroupDetailDTO;
import controller.ItemGroupController;
import controller.ItemGroupControllerImpl;
import entity.ItemGroup;

public class ItemGroupView {
	private static final ItemGroupController controller;

	static {
		controller = new ItemGroupControllerImpl();
	}

	public static void main(String[] args) {
		List<ItemGroup> itemGoups = controller.getAll();
		itemGoups.forEach(System.out::println);
		System.out.println("================");
		List<ItemGroup> itemGroupsByName = controller.getName("Mu");
		itemGroupsByName.forEach(System.out::println);
		System.out.println("================");
		ItemGroup itemGroupsById = controller.getId(1);
		System.out.println(itemGroupsById);
		//4
		List<ItemGroupDetailDTO> result = controller.getItemGroupDetails();
		System.out.println(result);
	}
	
	
}