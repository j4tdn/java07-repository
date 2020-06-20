package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import beans.Apple;
import Predicate.StrategyPredicate;
import sevice.AppleSevice;
import sevice.AppleSeviceImpliment;

public class Ex01ComparatorAndPredicate {
private static AppleSevice sevice = new AppleSeviceImpliment();
	
	public static void main(String[] args) {
		List<Apple> inventory = sevice.getAll();
		
		inventory.sort(Comparator.comparing(Apple::getOrigin)
				.thenComparing(Apple::getWeight,Comparator.reverseOrder()));
		
		Predicate<Apple> redPre = a->"red".equals(a.getColor());
		Predicate<Apple> weightPre=a->a.getWeight()>150;
		
		List<Apple> weightApples= sevice.filter(inventory,weightPre);
		List<Apple> redApples = sevice.filter(inventory,redPre);
		List<Apple> result =sevice.filter(inventory, redPre.negate().or(weightPre));
		
		weightApples.forEach(System.out::println);
		
		inventory.forEach(System.out::println);
		
		result.forEach(System.out::println);
	}
}
