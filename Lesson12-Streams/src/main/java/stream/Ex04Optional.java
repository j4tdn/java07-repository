package stream;

import java.util.Optional;

import beans.Apple;

public class Ex04Optional {
	public static void main(String[] args) {
		Optional<Apple> a = Optional.ofNullable(getApple("id-01"));
		a.ifPresent(System.out::println);
		System.out.println("=============");
	}

	private static Apple getApple(String id) {
		Apple a = new Apple("green");
		return a;
	}
}