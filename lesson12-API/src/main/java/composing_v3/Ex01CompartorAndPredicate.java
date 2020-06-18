package composing_v3;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


import beans.Apple;
import functions.StrategyPredicate;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01CompartorAndPredicate {
	private static AppleService service = new AppleServiceImpl();
	
	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		inventory.sort(Comparator.comparing(Apple::getOrigin)
				.thenComparing(Apple::getWeight));
		
		
		Predicate<Apple> redPre =  a -> "red".equals(a.getColor());
		Predicate<Apple> weight =  a -> a.getWeight() > 150;
		
		List<Apple> wightApple = service.filter(inventory, redPre);
		List<Apple> colorApple = service.filter(inventory,weight);
		List<Apple> result = service.filter(inventory, redPre.negate().or(weight));
				
		inventory.forEach(System.out::println);
		
		
	}
	

}
