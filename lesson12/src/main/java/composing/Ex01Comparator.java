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
		// for(Apple apple:inventory) {

		// }
		Predicate<Apple> redPre = a -> "red".equals(a.getColor());
		Predicate<Apple> weiPre = a -> a.getWeight() > 150;
		List<Apple> weight = service.filter(inventory, weiPre);
		List<Apple> redApple = service.filter(inventory, redPre);
		List<Apple> result = service.filter(inventory, redPre.negate().and(weiPre));

		result.forEach(System.out::println);

	}
}