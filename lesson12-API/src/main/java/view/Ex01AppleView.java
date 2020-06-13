package view;

import java.util.List;

import beans.Apple;
import predicate.StrategyPredicate;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01AppleView {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		show(inventory);
		// anomimus class
		
		StrategyPredicate<Apple> pre = (Apple a ) -> {return true;};
		
		
		List<Apple> expected = service.filter(inventory, (Apple a) -> a.getWeight() > 100);
		List<Apple> expectedGreenAplle = service.filter(inventory, (Apple a) -> "green".equals(a.getColor()));
		show(expected);
		show(expectedGreenAplle);

	}

	private static void show(List<Apple> inventory) {
		for (Apple apple : inventory) {
			System.out.println(apple);
		}
	}

}
