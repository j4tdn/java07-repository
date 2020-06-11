package view;

import java.util.List;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01AppleView {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		show(inventory);
		System.out.println("==================");

		// anonymous class
//		ApplePredicate predicate = apple -> "green".equals(apple.getColor());

		List<Apple> expected = service.filter(inventory,
				apple -> "green".equals(apple.getColor()) && apple.getWeight() >= 120);
		show(expected);
	}

	private static void show(List<Apple> inventory) {
		for (Apple a : inventory) {
			System.out.println(a);
		}
	}
}