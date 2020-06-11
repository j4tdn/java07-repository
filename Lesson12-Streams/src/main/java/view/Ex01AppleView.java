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

		// anonymous class
		StrategyPredicate<Apple> predicate = new StrategyPredicate<Apple>() {

			@Override
			public boolean test(Apple apple) {
				// TODO Auto-generated method stub
				return "green".equals(apple.getColor());
			}
		};
		StrategyPredicate<Apple> predicates = (Apple apple) -> apple.getWeigth() >= 100;

		List<Apple> greenApple = service.filter(inventory, predicate);
		List<Apple> expectedApple = service.filter(inventory, predicates);
		List<Apple> redApple = service.filter(inventory, a->"red".equals(a.getColor()));
		
		// show(inventory);
		show(greenApple);
		System.out.println("===============================");
		show(expectedApple);
		System.out.println("===============================");
		show(redApple);

	}

	private static void show(List<Apple> inventory) {
		for (Apple apple : inventory) {
			System.out.println(apple);
		}
	}

}
