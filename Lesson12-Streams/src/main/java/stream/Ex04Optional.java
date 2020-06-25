package stream;

import java.util.Optional;

import beans.Apple;

public class Ex04Optional {
	public static void main(String[] args) {
		Optional<Apple> optional = Optional.ofNullable(getApple("1"));
		optional.ifPresent(System.out::println);;
		System.out.println("======================");
	}
	
	private static Apple getApple(String id) {
		//calcullator
		Apple a = new Apple("green");
		return a;
	}
}
