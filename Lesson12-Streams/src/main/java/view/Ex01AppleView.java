package view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import bean.Apple;
import functions.StrategyPredicate;
import service.AppleService;
import service.AppleServiceimpl;

public class Ex01AppleView {
	private static AppleService service = new AppleServiceimpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		// StrategyPredicate<Apple> pre = (Apple a)->true;

		List<Apple> greenApple = service.filter(inventory, a -> a.getWeight() > 100);

		show(greenApple);

		List<String> countries = map(greenApple, Apple::getOrigin);
		show(countries);
		inventory.sort(Comparator.comparing(Apple::getColor));
		Map<String, Integer> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getColor,Apple::getWeight,(i1,i2)->i1));
		map.forEach((k,v)->System.out.println(k+","+v));
	}

	private static <T, R> List<R> map(List<T> ts, Function<T, R> func) {
		List<R> reusult = new ArrayList<>();
		for (T t : ts) {
			reusult.add(func.apply(t));
		}
		return reusult;
	}

	private static void show(List<?> inventory) {
		Function<Apple, String> func = Apple::getColor;
		inventory.forEach(System.out::println);
	}
}
