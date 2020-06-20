package view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01AppleView {

	private static AppleService service = new AppleServiceImpl();

	public static <U> void main(String[] args) {
		List<Apple> inventory = service.getAll();

		List<Apple> expected = service.filter(inventory, a -> a.getWeight() < 200);
		List<Apple> greenApples = service.filter(inventory, a -> "green".equals(a.getColor()));

		show(expected);

		System.out.println("=======================");
		show(greenApples);

		List<String> countries = map(greenApples, Apple::getOrigin);

		System.out.println("=======================");
		show(countries);

		// put definition into practice
		inventory.sort(Comparator.comparing(Apple::getColor));

		Map<String, Integer> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getColor, Apple::getWeight, (i1, i2) -> i1));
		
		System.out.println("=======================");
		show(inventory);

		System.out.println("=======================");
		map.forEach(new BiConsumer<String, Integer>() {

			@Override
			public void accept(String t, Integer u) {
				System.out.println(t + "=> " + u);
			}
		});
	}

	private static <T, R> List<R> map(List<T> ts, Function<T, R> func) {
		List<R> result = new ArrayList<>();

		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;
	}

	private static void show(List<?> inventory) {
		inventory.forEach(System.out::println);
	}
}
