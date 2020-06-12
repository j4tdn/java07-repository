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

		StrategyPredicate<Apple> test = (Apple a) -> {
			return true;
		};

		// anonymous class
		StrategyPredicate<Apple> predicate = a->a.getWeight()>100;


		List<Apple> expected = service.filter(inventory, a->a.getWeight()>100);
		List<Apple> expectedGreenApple = service.filter(inventory, a->"green".equals(a.getColor()));
		show(expectedGreenApple);
	}

	private static void show(List<Apple> inventory) {
		for (Apple apple : inventory) {
			System.out.println(apple);
		}
	}
}
