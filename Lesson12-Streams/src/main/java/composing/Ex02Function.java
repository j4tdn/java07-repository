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
		Function<String, String> f = s -> s + s;
		// String s="Hello";
		// System.out.println(f.apply(s));
		Function<String, Integer> g = s -> s.length();
		Function<String, Integer> r = f.andThen(g);
		// andThen: f -> g
		// compose: g -> f
		System.out.println("Length: " + r.apply("xinchao"));

		// sort list of apples by store id
		List<Apple> inventory = service.getAll();

		Function<Apple, Store> storeFunc = Apple::getStore;
		Function<Store, String> storeIdFunc = Store::getId;
		Function<Apple, String> func = a -> a.getStore().getId();
		inventory.sort(Comparator.comparing(a -> a.getStore().getId()));
	}
}
