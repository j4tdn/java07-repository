package stream;

import java.util.Arrays;
import java.util.Collections;
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
		System.out.println("====Elements of inventory====");
		List<Apple> inventory = service.getAll();
		inventory.forEach(System.out::println);
		System.out.println();
		Set<String> result = inventory.stream().filter(a -> a.getWeight() > 150)
				.limit(2)
				.map(Apple::getOrigin)
				.collect(Collectors.toSet());
		result.forEach(System.out::println);
		System.out.println();
		
		Map<String, Apple> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getOrigin, a -> a, (e1, e2) -> e1, LinkedHashMap::new));
			
		List<Apple> dictinct = map.entrySet().stream()
				.map(Entry::getValue)
				.collect(Collectors.toList());
		dictinct.forEach(System.out::println);
		System.out.println();
		
		Set<String> originSet = new HashSet();
		Apple[] apples = inventory.stream()
				.filter(distinctByKey(Apple::getColor))
				.toArray(Apple[]::new);
		
		Arrays.stream(apples).forEach(System.out::println);
	}
	
	private static <T, R> Predicate<T> distinctByKey(Function<T, R> func){
		Set<R> originSet = new HashSet();
		return a -> originSet.add(func.apply(a));
	}
}
