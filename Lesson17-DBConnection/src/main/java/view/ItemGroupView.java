package view;

import java.util.List;
import java.util.Scanner;

import controller.ItemGroupController;
import controller.ItemGroupControllerImpl;
import dto.ItemGroupDetailDto;
import entities.ItemGroup;

public class ItemGroupView {
	private static Scanner sc = new Scanner(System.in);
	private static ItemGroupController itemGroupController;
	
	static {
		itemGroupController = new ItemGroupControllerImpl();
	}
	public static void main(String[] args) {
		
		// 1.get all itemGroups
		List<ItemGroup> itemGroups = itemGroupController.getAll();
		// method reference
		itemGroups.forEach(System.out::println);
		System.out.println("========================");
		// 2.get itemGroup by name
		String input =sc.nextLine();
		List<ItemGroup> itemGroupByName = itemGroupController.get(input);
		itemGroupByName.forEach(System.out::println);
		System.out.println("========================");
		// 3.get itemGroup by id
		ItemGroup itemGroupById = itemGroupController.get(2);
		System.out.println(itemGroupById);
		System.out.println("===================================");
		// 4.using DTO
		List<ItemGroupDetailDto> result = itemGroupController.getItemGroupDetails();
		System.out.println(result);
		
	}

}
