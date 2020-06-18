package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import beans.Apple;
import functions.StrateryPredicate;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01ComparatorAndPredicate {
	
	private static AppleService service = new AppleServiceImpl();
	
	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		
		inventory.sort(Comparator.comparing(Apple::getOrigin).thenComparing(Apple::getWeight, Comparator.reverseOrder()));
		
		Predicate<Apple> redPre = a -> "red".equals(a.getColor());
		Predicate<Apple> weightPre = a -> a.getWeight() > 150;
		
		// > 150
		List<Apple> weightApple = service.filter(inventory, a -> a.getWeight() > 150);
		List<Apple> redApple = service.filter(inventory, a -> "red".equals(a.getColor()));
		List<Apple> result = service.filter(inventory, redPre.negate().or(weightPre));
		
		show(result);
	}
	
	private static void show(List<Apple> inventory) {
		inventory.forEach(System.out::println);
	}
}
