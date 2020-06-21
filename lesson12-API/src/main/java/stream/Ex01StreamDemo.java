package stream;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01StreamDemo {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		// external interation for theo ý của mình

		// internal interation || loop
		List<String> result = inventory.stream().filter(a -> a.getWeight() > 150).limit(4).map(Apple::getOrigin)
				.distinct().collect(Collectors.toList());
		result.forEach(System.out::println);
		System.out.println("================================");

		// distinct theo 1 thuộc tính thì map(key,value)

		Map<String, Apple> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getOrigin, a -> a, (a1,a2) -> a1,LinkedHashMap :: new ));
		
		List<Apple> distinct = map.entrySet().stream()
				.map(java.util.Map.Entry::getValue)
				.collect(Collectors.toList());
		distinct.forEach(System.out::println);
		System.out.println("===============================");
		Set<String> originSet = new HashSet<>();
		Array[] apples = inventory.stream().filter(disticByKey(Apple::getOrigin)).toArray(Apple);
		Arrays.stream(apples).forEach(System.out::println);
	}
	private static<T,R> Predicate<T> disticByKey(Function<T, R> func){
		Set<String> origins = new HashSet<String>();
		return a -> origins.add((String) func.apply(a));
	}
}
