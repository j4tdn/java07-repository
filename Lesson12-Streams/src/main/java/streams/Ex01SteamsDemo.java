package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01SteamsDemo {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		// traversable once only
		List<Apple> result = inventory.stream().distinct()
				// .filter(a -> a.getWeight() > 150)
				// .limit(3)
				.collect(Collectors.toList());
		Map<String, Apple> map = inventory.stream()

				.distinct().collect(Collectors.toMap(Apple::getOrigin, a -> a, (a1, a2) -> a1, LinkedHashMap::new));

		List<Apple> distinct = map.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());

		distinct.forEach(System.out::println);
		System.out.println("===========================");
		Set<String> origin = new HashSet<>();
		Apple[] apples = inventory.stream().filter(distinctByKey(Apple::getColor)).toArray(Apple[]::new);

		Arrays.stream(apples).forEach(System.out::println);

	}

	private static <T, R> Predicate<T> distinctByKey(Function<T, R> func) {
		Set<R> origin = new HashSet<>();
		return a -> origin.add(func.apply(a));

	}

}
