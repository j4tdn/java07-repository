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
import java.util.stream.Stream;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01StreamDemo {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		// external iteration
		// for (Apple a: inventory) {
			// your code
			// System.out.println(a);
		// }
		
		
		// internal iteration || loop
		List<String> result = inventory.stream()
				.filter(a -> {
					return a.getWeight() > 150;
				})
				.limit(3)
				.map(Apple::getOrigin)
				.distinct()
				.collect(Collectors.toList());
		result.forEach(System.out::println);
		
		System.out.println("=====================");
		
		Map<String, Apple> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getOrigin, 
						a -> a,
						(a1, a2) -> a1, 
						LinkedHashMap::new));

		List<Apple> distinct = map.entrySet().stream()
				.map(Entry::getValue)
				.collect(Collectors.toList());
		distinct.forEach(System.out::println);
		
		System.out.println("=========distinct by key============");
		Apple[] apples = inventory.stream().filter(distictByKey(Apple::getColor)).toArray(Apple[]::new);
		Arrays.stream(apples).forEach(System.out::println);
	}
	
	private static <T, R> Predicate<T> distictByKey(Function<T, R> func) {
		Set<R> originSet = new HashSet<>();
		return a -> originSet.add(func.apply(a));
	}
	
}
