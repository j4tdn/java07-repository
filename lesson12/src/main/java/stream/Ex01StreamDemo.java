package stream;

import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Apple;
import java07.lesson12.App;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01StreamDemo {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		List<String> result = inventory.stream().filter(a -> {
			System.out.println("===================");
			return a.getWeight() > 150;
		}).limit(1).map(Apple::getOrigin).collect(Collectors.toList());

		Map<String, Apple> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getOrigin, a -> a, (a1, a2) -> a1, LinkedHashMap::new));
		List<Apple> distinct = map.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
		distinct.forEach(System.out::println);

		Set<String> originset = new HashSet<>();
		Apple[] apples = inventory.stream().filter(new Predicate<Apple>() {
			@Override
			public boolean test(Apple a) {
				return originset.add(a.getOrigin());
			}
		}).toArray(Apple[]::new);
		Arrays.stream(apples).forEach(System.out::println);
	}

	private static <T, R> Predicate<Apple> distictByKey(Function<T, R> func) {
		Set<R> originSet = new HashSet<>();
		return a -> originSet.add(func.apply(a));
	}

}
