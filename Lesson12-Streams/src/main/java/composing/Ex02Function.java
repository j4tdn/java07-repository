package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex02Function {

	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		Function<String, String> f = s -> s + s;
		Function<String, Integer> g = s -> s.length();
		Function<String, Integer> r = f.andThen(g);
		System.out.println("length: " + r.apply("Long"));

		// sort list of Apple by store id
		List<Apple> inventory = service.getAll();

		inventory.sort(Comparator.comparing(a -> a.getStore().getId()));
	}
}
