package stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01StreamDemo {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		// inventory.forEach(System.out::println);

		// external iteration : faster than internal
		/*
		 * for (Apple a:inventory) { 
		 * 		System.out.println(a); 
		 * }
		 */

		// internal iteration || loop : slower than external but generic
		List<String> result = inventory.stream().filter(a -> {
				return a.getWeight() > 150;
		})
				.limit(2).map(Apple::getOrigin)
				.distinct() // distinct cua stream dua vao ham equals
							// distinct cua collections dua vao ca equals va hashcode
				.collect(Collectors.toList()); // toSet
		// filter, limit, map ... : intermediate operation (Lazy pattern) , chi thuc
		// hien khi terminal operation dc goi
		// collect, forEach, count : terminal operation
		result.forEach(System.out::println);

		System.out.println("=============================");
		// distinct by origin
		Map<String, Apple> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getOrigin, a -> a, (a1, a2) -> a1, LinkedHashMap::new));
		List<Apple> distinct = map.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
		distinct.forEach(System.out::println);

		System.out.println("=============================");

		Apple[] originArray = inventory.stream().filter(distinctByKey(Apple::getColor)).toArray(Apple[]::new);
		Arrays.stream(originArray).forEach(System.out::println);
	}

	private static <T, R> Predicate<T> distinctByKey(Function<T, R> func) {
		Set<R> originSet = new HashSet<>();
		return a -> originSet.add(func.apply(a));
	}
}
