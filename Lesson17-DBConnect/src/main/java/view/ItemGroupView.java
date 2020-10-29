package view;

import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import controller.ItemGroupController;
import controller.ItemGroupControllerImpl;
import dto.ItemGroupDetailDto;
import entities.ItemGroup;

public class ItemGroupView {
	
	private static ItemGroupController controller;
	
	static {
		controller = new ItemGroupControllerImpl();
	}
	
	public static void main(String[] args) {
		List<ItemGroup> groups = controller.getAll();
		groups.forEach(System.out::println);
		System.out.println("============");
		List<ItemGroup> groups2 = controller.get("Áo");
		groups2.forEach(System.out::println);
		System.out.println("=============");
		ItemGroup group = controller.get(3);
		System.out.println(group);
		System.out.println("===========");
		List<ItemGroupDetailDto> result = controller.getItemGroupDetails();
		System.out.println(result);
		
	}
}
