package view;

import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import controller.ItemGroupController;
import controller.ItemGroupControllerImpl;
import entities.ItemGroup;

public class ItemGroupView {
	private static ItemGroupController itemGroupController;
	static {
		itemGroupController=new ItemGroupControllerImpl() ;
	}
	public static void main(String[] args) {
		List<ItemGroup> itemGroups=itemGroupController.getAll();{
			itemGroups.forEach(System.out::println);
		}
	}
}