package views;

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

		StrategyPredicate<Apple> test = (Apple a) -> {
			return true;
		};

		// anonymous
		List<Apple> greenApple = service.filter(inventory, a -> "green".equals((a).getColor()));
		List<Apple> expexted = service.filter(inventory, a -> (a).getWeight() > 100);
		System.out.println("==========================================");
		show(greenApple);
		System.out.println("==========================================");
		show(expexted);
	}

	private static void show(List<Apple> inventory) {
		for (Apple apple : inventory) {
			System.out.println(apple);
		}
	}
}
