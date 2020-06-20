package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import beans.Apple;
import function.StrategyPredicate;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01ComparatorAndPredicate {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {

		List<Apple> inventory = service.getAll();

		inventory.sort(
				Comparator.comparing(Apple::getOrigin).thenComparing(Apple::getWeight, Comparator.reverseOrder()));
		
		Predicate<Apple> redPre = a-> "green".equals(a.getColor());
		Predicate<Apple> weigthPre = a -> a.getWeight()>80 ;
		
		List<Apple> weigthApple = service.filter(inventory, weigthPre);
		List<Apple> redApple = service.filter(inventory, redPre);
		
		List<Apple> result = service.filter(inventory, redPre.negate().or(weigthPre));
		
		inventory.forEach(System.out::println);
		System.out.println("==========================");
		result.forEach(System.out::println);
		
	}

}
