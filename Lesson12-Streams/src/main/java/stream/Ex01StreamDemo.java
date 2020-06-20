package stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01StreamDemo {
	
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		// stream traversable one only
		Set<String> result = inventory.stream().filter(a -> a.getWeight() > 150).map(Apple::getOrigin).limit(3)
				.collect(Collectors.toSet());
		result.forEach(System.out::println);

	}

}
