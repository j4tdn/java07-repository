package view;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import beans.Apple;
import predicate.StrategyPredicate;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01AppleView {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		// Ex
		// ApplePredicate test = apple -> apple.getWeight() > 100;

		Runnable r = () -> {
		};

		Function<String, Apple> f = s -> null;

		Comparator<Integer> c = (i1, i2) -> 0;

		StrategyPredicate<Apple> s = (a) -> true;

		// end Ex
		// anonymous function thay cho anonymous class khi anonymous class chỉ có 1 hàm
		// trừu tượng
		// anonymous class
		// ApplePredicate predicate = apple -> apple.getWeight() > 100;

		List<Apple> expected = service.filter(inventory, apple -> apple.getWeight() > 100);
		show(expected);
		System.out.println("================");
		List<Apple> greenApple = service.filter(inventory, apple -> "green".equals((apple).getColor()));
		show(greenApple);
	}

	public static void show(List<Apple> inventory) {
		for (Apple apple : inventory) {
			System.out.println(apple);
		}
	}
}
