package stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Set;
import java.util.stream.Collectors;

import bean.Apple;
import service.AppleService;
import service.AppleServiceimpl;

public class Ex01StreamDemo {
	private static AppleService service = new AppleServiceimpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		List<Apple> result = inventory.stream()
				.collect(Collectors.toMap(Apple::getOrigin, a -> a, (a1, a2) -> a1, LinkedHashMap::new)).entrySet()
				.stream().map(Entry::getValue).collect(Collectors.toList());
		result.forEach(System.out::println);
		System.out.println("==============================");

		Apple[] app = inventory.stream().filter(distinctByKey(Apple::getColor)).toArray(Apple[]::new);

		Arrays.stream(app).forEach(System.out::println);
	}

	private static <T, R> Predicate<T> distinctByKey(Function<T, R> func) {
		Set<R> originSet = new HashSet<>();
		return a -> originSet.add(func.apply(a));
	}
}