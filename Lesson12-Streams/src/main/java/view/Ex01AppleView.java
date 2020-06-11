package view;

import java.util.List;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01AppleView {

	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		List<Apple> expected = service.filter(inventory, a -> a.getWeight() < 200);
		List<Apple> expectedGreenApples = service.filter(inventory, a -> "green".equals(a.getColor()));

		show(expected);
		System.out.println("=======================");
		show(expectedGreenApples);
	}

	private static void show(List<Apple> inventory) {
		for (Apple apple : inventory) {
			System.out.println(apple);
		}
	}
}
