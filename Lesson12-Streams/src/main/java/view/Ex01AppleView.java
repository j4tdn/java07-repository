package view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
		System.out.println("==================");

		List<String> contries = map(inventory, Apple::getOrigin);
		show(contries);

//		put definition into practice
		inventory.sort((o1, o2) -> o1.getColor().compareTo(o2.getColor()));
//		inventory.sort(Comparator.comparing(Apple::getColor));
		show(inventory);

		Map<String, Integer> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getColor, Apple::getWeight, (i1, i2) -> i1));
		map.forEach((k, v) -> System.out.println(k + ", " + v));
	}

	private static <T> void show(List<T> ts) {
//		inventory.forEach(System.out::println);
//		Consumer<Apple> con = System.out::println;
//		inventory.forEach(con);
//		Function<Apple, String> fun = Apple::getColor;

		ts.forEach(System.out::println);
	}

	private static <T, R> List<R> map(List<T> ts, Function<T, R> fun) {
		List<R> result = new ArrayList<>();
		for (T t : ts) {
			result.add(fun.apply(t));
		}
		return result;
	}
}