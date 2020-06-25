package stream;

import java.util.Optional;

import beans.Apple;

public class Ex04Optional {
	public static void main(String[] args) {
		Optional<Apple> optional= Optional.ofNullable(getApple("123"));
		optional.ifPresent(a->System.out.println(a));
		System.out.println("============================");
	}
	
	public static Apple getApple(String id) {
		Apple a=new Apple("green");
		return a;
	}
}
