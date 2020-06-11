package view;

import java.util.List;
import bean.Apple;
import predicate.StrategyPredicate;
import service.AppleService;
import service.AppleServiceImplement;

public class Ex01AppleView {
	private static AppleService service = new AppleServiceImplement();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		
		StrategyPredicate<Apple> pre = (a) -> {
			return true;
		};

		List<Apple> greenApple = service.filter(inventory, apple -> "green".equals((apple).getColor()));

		show(inventory);
		System.out.println("======================");
		show(greenApple);
	}

	private static void show(List<Apple> inventory) {
		for (Apple apple : inventory) {
			System.out.println(apple);
		}
	}

}
