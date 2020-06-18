package view;

import java.util.List;

import Predicate.StrategyPredicate;
import beans.Apple;
import sevice.AppleSevice;
import sevice.AppleSeviceImpliment;

public class Ex01AppleView {

	private static AppleSevice sevice = new AppleSeviceImpliment();

	public static void main(String[] args) {
		List<Apple> inventory = sevice.getAll();
		StrategyPredicate<Apple> predicate = (Apple a) -> {
			return true;
		};

		// List<Apple> greenApples = sevice.filter(inventory,predicate);

		show(inventory);
	}

	private static <T> void show(List<T> inventory) {
		for (T apple : inventory) {
			System.out.println(apple);
		}
	}
}
