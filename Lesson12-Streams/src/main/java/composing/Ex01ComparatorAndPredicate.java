package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import bean.Apple;
import functions.StrategyPredicate;
import service.AppleService;
import service.AppleServiceimpl;

public class Ex01ComparatorAndPredicate {
	
	private static AppleService service = new AppleServiceimpl();
	
	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		
		inventory.sort(Comparator.comparing(Apple::getOrigin)
				.thenComparing(Apple::getWeight,Comparator.reverseOrder()));
		
		Predicate<Apple> redPre = a->"red".equals(a.getColor());
		Predicate<Apple> weightPre=a->a.getWeight()>150;
		
		List<Apple> weightApples= service.filter(inventory,weightPre);
		List<Apple> redApples = service.filter(inventory,redPre);
		List<Apple> result =service.filter(inventory, redPre.negate().or(weightPre));
		
		weightApples.forEach(System.out::println);
		
		inventory.forEach(System.out::println);
		
		result.forEach(System.out::println);
	}
}
