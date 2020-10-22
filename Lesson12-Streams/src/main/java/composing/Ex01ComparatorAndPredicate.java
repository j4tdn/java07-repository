package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import beans.Apple;
import functions.StrategyPredicate;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01ComparatorAndPredicate {

	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		inventory.sort(
				Comparator.comparing(Apple::getOrigin).thenComparing(Apple::getWeight, Comparator.reverseOrder()));
		
		Predicate<Apple> redPre = a -> "red".equals(a.getColor());
		Predicate<Apple> weightPre = a -> a.getWeight() > 180;
		
		List<Apple> weightApples = service.filter(inventory, weightPre);
		List<Apple> redApples = service.filter(inventory, redPre);
		List<Apple> result = service.filter(inventory, redPre.negate().or(weightPre));
		result.forEach(System.out::println);
	}
}
