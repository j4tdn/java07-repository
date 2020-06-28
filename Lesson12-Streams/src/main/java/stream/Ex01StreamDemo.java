package stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Set;
import java.util.stream.Collectors;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01StreamDemo {

	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		// internal iteration || loop
		Set<String> result = inventory.stream().filter(a -> a.getWeight() > 150).limit(3).map(Apple::getOrigin)
				.collect(Collectors.toSet());

		Map<String, Apple> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getOrigin, a -> a, (a1, a2) -> a1, LinkedHashMap::new));

		List<Apple> distinct = map.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());

		Apple[] distinctByFilter = inventory.stream().filter(distinctByKey(Apple::getColor)).toArray(Apple[]::new);

		result.forEach(System.out::println);

		System.out.println("==================");
		distinct.forEach(System.out::println);

		System.out.println("==================");
		Arrays.stream(distinctByFilter).forEach(System.out::println);
	}

	private static <T, R> Predicate<T> distinctByKey(Function<T, R> func) {
		Set<R> originSet = new HashSet<>();
		return a -> originSet.add(func.apply(a));
	}
}
