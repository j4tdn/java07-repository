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
		Function<String, Integer> g = s -> s.length();
		Function<String, Integer> r = g.compose(f);
		String s = f.apply("hello ");

		System.out.println("s : " + s);
		System.out.println("length : " + r.apply("xinchao"));
		// sort list of apples by store id
		List<Apple> inventory = service.getAll();

		Function<Apple, Store> storeFunc = Apple::getStore;
		Function<Store, String> storeIdFunc = Store::getId; //cach 1

		Function<Apple, String> func = a -> a.getStore().getId();// cach 2
		inventory.sort(Comparator.comparing(func));

	}

}
