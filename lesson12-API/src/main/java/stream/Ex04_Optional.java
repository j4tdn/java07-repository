package stream;

import java.util.Optional;

import beans.Apple;

public class Ex04_Optional {
	public static void main(String[] args) {
		Optional<Apple> optional = Optional.ofNullable(getApple("123"));
		optional.ifPresent(a -> System.out.println(a));
		System.out.println("=====================================");
		
	}
	private static Apple getApple(String id) {
		Apple a = new Apple("green");
		return a;
	}
}
