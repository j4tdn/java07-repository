package views;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import controller.ItemGroupController;
import controller.ItemGroupControllerImpl;
import entities.ItemGroup;

public class ItemGroupView {
	
	private static ItemGroupController itemGroupController;
	
	static {
		itemGroupController = new ItemGroupControllerImpl();
	}
	
	public static void main(String[] args) {
		List<ItemGroup> itemGroups = itemGroupController.getAll();
		List<ItemGroup> itemGroupsByName = itemGroupController.getByName("XY");
		ItemGroup itemGroup = itemGroupController.getById(0);
		//itemGroups.forEach(System.out::println);
		itemGroupsByName.forEach(System.out::println);
		//System.out.println(itemGroup);
	}
}
