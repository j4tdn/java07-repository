package view;

import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import controller.ItemGroupController;
import controller.ItemGroupControllerImpl;
import dto.ItemGroupDetailDTO;
import entities.ItemGroup;

public class ItemGroupView {
	private static ItemGroupController  itemGroupController;
	
	static {
		itemGroupController=new ItemGroupControllerImpl();
	}
	public static void main(String[] args) {
		List<ItemGroup> itemGroups=itemGroupController.getAll();
		//method reference
		itemGroups.forEach(System.out::println);
		System.out.println("================");
		
		//get itemGroup by name
		List<ItemGroup> itemGroupByName=itemGroupController.get("Áo");
		itemGroupByName.forEach(System.out::println);
		System.out.println("==========================");
		//get Itemgroup by id
		ItemGroup itemGroupById=itemGroupController.get(3);
		System.out.println(itemGroupById);
		
		//4.using dto
		List<ItemGroupDetailDTO> result=itemGroupController.getItemGroupDetails();
		System.out.println(result);
	}
}
