package view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import beans.Apple;
import function.StrategyPredicate;
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
		System.out.println("======================");
		List<String> countries = map(inventory, Apple::getOrigin);
		show(countries);
		System.out.println("======================");
				
		// put definition into practice
		inventory.sort(Comparator.comparing(Apple::getColor));
		show(inventory);
		System.out.println("======================");
		Map<String, Integer> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getColor, Apple::getWeight, (i1, i2) -> i1));
		map.forEach((k, v) -> System.out.println(k + ", " + v));
	}


	private static void show(List<?> inventory) {
		// Function<Apple, String> func = Apple::getColor; // a->a.getColor()
		inventory.forEach(System.out::println);
	}
	
	private static <T, R> List<R> map(List<T> ts, Function<T, R> func) {
		List<R> result = new ArrayList<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;
	}
}