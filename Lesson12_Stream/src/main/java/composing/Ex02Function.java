package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import beans.Apple;
import beans.Store;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex02Function {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		Function<String, String> f = t -> t + t;

		// System.out.println(f.apply("s"));

		Function<String, Integer> g = t -> t.length();
		Function<String, Integer> r = f.andThen(g);
		System.out.println(r.apply("xinchao"));

		// sort list of apples by store id
		List<Apple> inventory = service.getAll();

		inventory.sort(Comparator.comparing(a -> a.getStore().getId()));
	}
}
