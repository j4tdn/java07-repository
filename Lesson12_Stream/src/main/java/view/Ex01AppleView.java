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
import function.Predicate;
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
		Predicate<Apple> s = (a) -> true;

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
		List<String> countries = map(greenApple, Apple::getOrigin);
		show(countries);

		// put definition into paractive
		System.out.println("==========");
		inventory.sort(Comparator.comparing(Apple::getColor));
		show(inventory);

		Map<String, Integer> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getColor, Apple::getWeight, (a1, a2) -> a1));
		map.forEach((t, u) -> System.out.println(t + "->" + u)

		);

	}

	public static <T, R> List<R> map(List<T> ts, Function<T, R> function) {
		List<R> result = new ArrayList<>();
		for (T t : ts) {
			result.add(function.apply(t));
		}
		return result;

	}

	public static void show(List<?> inventory) {

		inventory.forEach(System.out::println);

	}
}
