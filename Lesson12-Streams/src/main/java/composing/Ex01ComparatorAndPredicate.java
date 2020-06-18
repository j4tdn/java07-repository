package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01ComparatorAndPredicate {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		inventory.sort(Comparator.comparing(Apple::getOrigin)
				.thenComparing(Apple::getWeight, Comparator.reverseOrder()));
		// tang dan cua country -> giam dan cua weight

		inventory.forEach(System.out::println);
		System.out.println("===========================================");

		Predicate<Apple> weightPre = a -> a.getWeight() > 150;
		Predicate<Apple> redPre = a -> "red".equals(a.getColor());
		List<Apple> weightApples = service.filter(inventory, weightPre);
		List<Apple> redApples = service.filter(inventory, redPre);

		// >150 & red
		List<Apple> result = service.filter(inventory, redPre.and(weightPre));
		result.forEach(System.out::println);
		System.out.println("==========================================");
		// ko phai red & >150
		List<Apple> result1 = service.filter(inventory, redPre.negate().and(weightPre));
		result1.forEach(System.out::println);
	}
}
