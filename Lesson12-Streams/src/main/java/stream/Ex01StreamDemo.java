package stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Apple;
import service.AppleService;
import service.AppleServiceimpl;

public class Ex01StreamDemo {
	private static AppleService service = new AppleServiceimpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		Set<String> result = inventory.stream().filter(a -> a.getWeight() > 150).limit(2).map(Apple::getOrigin).collect(Collectors.toSet());
		result.forEach(System.out::println);
	}
}
