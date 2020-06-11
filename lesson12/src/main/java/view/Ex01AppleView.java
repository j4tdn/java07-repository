package view;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01AppleView {
	public static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		// anonymousclass
		//ApplePredicate predicate=a->a.getWeight()>100;
//		StrategyPredicate predicate = new StrategyPredicate() {
//
//			@Override
//			public boolean test(Apple apple) {
//				// TODO Auto-generated method stub
//				// return "green".equals(apple.getColor());//truyen dieu kien vao day
//				return apple.getWeight() > 100;
//			}
//
//			@Override
//			public boolean test(Object apple) {
//				// TODO Auto-generated method stub
//				return false;
//			}
		//};
		List<Apple> greenApples = service.filter(inventory, a->a.getWeight()>100);
		List<Apple> expectedGreenApple=service.filter(inventory, a->"green".equals(a.getColor()));

		show(greenApples);

	}

	private static void show(List<Apple> inventory) {
		for (Apple apple : inventory) {
			System.out.println(apple);
		}
	}
}
