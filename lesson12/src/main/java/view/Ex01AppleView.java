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
	public static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		// anonymousclass
		// ApplePredicate predicate=a->a.getWeight()>100;
//		StrategyPredicate predicate = new StrategyPredicate() {
//
//			@Override
//			public boolean test(Apple apple) {
//				// TODO Auto-generated method stub
//				// return "green".equals(apple.getColor());//truyen dieu kien vao day
//				return apple.getWeight() > 100;
//			}
//
//			@Override
//			public boolean test(Object apple) {
//				// TODO Auto-generated method stub
//				return false;
//			}
		// };
		List<Apple> greenApples = service.filter(inventory, a -> a.getWeight() > 100);
		List<Apple> expectedGreenApple = service.filter(inventory, a -> "Lao".equals(a.getOrigin()));

		// show(expectedGreenApple);
		List<String> countries = map(greenApples, Apple::getOrigin);
		show(countries);
		inventory.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));// sap xep trong list
		show(inventory);
		Map<String, Integer> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getColor, Apple::getWeight, (i1, i2) -> i1));
		map.forEach((k, v) -> System.out.println(k + " " + v));

	}

	private static <T, R> List<R> map(List<T> ts, Function<T, R> func) {
		List<R> result = new ArrayList<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;

	}

	private static <T> void show(List<T> ts) {
		ts.forEach(System.out::println);
	}
}
