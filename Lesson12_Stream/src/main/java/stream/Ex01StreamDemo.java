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

		// external interation
//		for (Apple apple : inventory) {
//			System.out.println(apple);
//		}

		// stream traversable one only
		// internal interation

		List<String> result = inventory.stream().filter(a -> {
			return a.getWeight() > 150;
		}).map(Apple::getOrigin).limit(3).distinct().collect(Collectors.toList());

		Map<String, Apple> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getOrigin, a -> a, (a1, a2) -> a1, LinkedHashMap::new));

		
		List<Apple> distinct = map.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());

		System.out.println("======DistinctByKey============");
		Apple[] apples = inventory.stream().filter(distinct(Apple::getOrigin)).toArray(Apple[]::new);

		Arrays.stream(apples).forEach(System.out::println);
		System.out.println("=============");
		distinct.forEach(System.out::println);

	}

	private static Predicate<Apple> distinct(Function<Apple, String> func) {
		Set<String> originSet = new HashSet<>();
		return a -> originSet.add(func.apply(a));

	}
}
