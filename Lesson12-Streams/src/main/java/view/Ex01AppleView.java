package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import beans.Apple;
import functions.StrategyPredicate;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01AppleView {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		List<Apple> greenApples = service.filter(inventory, a -> "green".equals(a.getColor()));
		show(greenApples);
		
		List<String> countries = map(greenApples, Apple::getOrigin);
		show(countries);
		
		// put definition into practice
		inventory.sort(Comparator.comparing(Apple::getColor));
		show(inventory);
		
		Map<String, Integer> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getColor, 
						Apple::getWeight, 
						(i1, i2) -> i1));
		map.forEach((k, v) -> System.out.println(k + ", " + v));
	}

	private static <T, R> List<R> map(List<T> ts, Function<T, R> func) {
		List<R> result = new ArrayList<>();
		
		for (T t: ts ){
			result.add(func.apply(t));
		}
		
		return result;
	}
	
	private static void show(List<?> inventory) {
		// Function<Apple, String> func = Apple::getColor;
		inventory.forEach(System.out::println);
	}
}