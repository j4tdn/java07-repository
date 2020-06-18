package stream;

import java.util.List;
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
		Set<String> result = inventory.stream().filter(a -> a.getWeight() > 150)
				.limit(4)
				.map(Apple::getOrigin)
				.collect(Collectors.toSet());
		result.forEach(System.out::println);
		System.out.println("================================");
	}
}
