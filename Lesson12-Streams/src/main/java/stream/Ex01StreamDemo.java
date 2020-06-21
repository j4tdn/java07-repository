package stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01StreamDemo {
	private static AppleService service = new AppleServiceImpl();
	public static void main(String[] args) {
		List<Apple> inventory =  service.getAll();
		
		//external iterator
//		for (Apple a: inventory) {
//			System.out.println(a);
//		}
		
		//internal iterator
		Set<String> result = inventory.stream()
				.filter(a -> a.getWeight() > 150)
				.limit(2)
				.map(Apple::getOrigin)
				.collect(Collectors.toSet());
		result.forEach(System.out::println);
		
		Map<String, Apple> map = inventory.stream().collect(Collectors.toMap(Apple::getOrigin, a -> a, (a1, a2) -> a1, LinkedHashMap::new));
		List<Apple> distinct = map.entrySet().stream()
				.map(Entry::getValue)
				.collect(Collectors.toList());
		//distinct.forEach(System.out::println);
		
		Apple[] distinctFillter = inventory.stream()
				.filter(distinctByKey(Apple::getOrigin))
				.toArray(Apple[]::new);
		Arrays.stream(distinctFillter).forEach(System.out::println);
	}
	
	private static <T, R> Predicate<T> distinctByKey(Function<T, R> func) {
		Set<R> setOrigin = new HashSet<>();
		return a -> setOrigin.add(func.apply(a));
	}
}
