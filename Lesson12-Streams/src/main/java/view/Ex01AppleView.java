package view;

import java.util.List;

import beans.Apple;
import predicate.StrategyPredicate;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01AppleView {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		show(inventory);
		/*
		ApplePredicate test = (Apple apple) -> {
			return apple.getWeight() > 150;
		};
		*/
		
		
		// anonymous class
		// co the thay bang 1 lamda neu anonymous class chi co 1 ham truu tuong
		/*
		ApplePredicate applePredicate = new ApplePredicate() {

			@Override
			public boolean test(Apple apple) {
				return "green".equals(apple.getColor());
				// apple.getWeight()>150;
			}
		};
		*/

		// ApplePredicate applePredicate = a -> a.getWeight() > 150;
		
		StrategyPredicate<Apple> pre = (Apple a) -> a.getWeight() > 150;

		List<Apple> expected = service.filter(inventory, a -> "green".equals(a.getColor()));
		System.out.println("======================");
		show(expected);
		System.out.println("======================");
		expected = service.filter(inventory, (Apple a) -> a.getWeight() > 150);
		show(expected);
	}

	private static void show(List<Apple> inventory) {
		for (Apple apple : inventory) {
			System.out.println(apple);
		}
	}
}
