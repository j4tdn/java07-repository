package view;

import java.util.List;

import bean.Apple;
import predicate.StrategyPredicate;
import service.AppleService;
import service.AppleServiceimpl;

public class Ex01AppleView {
	private static AppleService service =new AppleServiceimpl();
	public static void main(String[] args) {
		List<Apple> inventory =service.getAll();
		
		//StrategyPredicate<Apple> pre = (Apple a)->true;
		
		List<Apple> greenApple = service.filter(inventory,a->a.getWeight()>100);
		
		show(greenApple);
	}
	private static void show(List<Apple> inventory) {
		for(Apple apple:inventory) {
			System.out.println(apple);
		}
	}
}
