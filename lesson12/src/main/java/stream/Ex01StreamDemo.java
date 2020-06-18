package stream;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01StreamDemo {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		List<String> result = inventory.stream().filter(a -> a.getWeight() > 150).limit(1).map(Apple::getOrigin).collect(Collectors.toList());
		result.forEach(System.out::println);
	}
}
