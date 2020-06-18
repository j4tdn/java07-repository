package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01Comparator {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		inventory.sort(
				Comparator.comparing(Apple::getOrigin).thenComparing(Apple::getWeight, Comparator.reverseOrder()));
		inventory.forEach(System.out::println);

		System.out.println("==================");
		List<Apple> result = service.filter(inventory, a -> a.getWeight() > 150);
		result.forEach(System.out::println);

		Predicate<Apple> red = a -> "red".equals(a.getColor());
		Predicate<Apple> weight = a -> a.getWeight() > 150;

		List<Apple> redApple = service.filter(inventory, a -> "red".equals(a.getColor()));
		redApple.forEach(System.out::println);
	}
}