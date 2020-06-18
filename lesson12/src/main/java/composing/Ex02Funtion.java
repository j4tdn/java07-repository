package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import beans.Apple;
import beans.Store;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex02Funtion {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {

		Function<String, String> f = s -> s + s;
		Function<String, Integer> g = s -> s.length();
		Function<String, Integer> r = f.andThen(g);
		// String s=f.apply("hola");
		// System.out.println("s: "+s);
		System.out.println(r.apply("xinchao"));
		List<Apple> inventory = service.getAll();
		// sort list of apple by store id
		Function<Apple, Store> storeFunc = Apple::getStore;
		Function<Store, String> storeIdFunc=Store::getId;
		Function<Apple, String> func =a->a.getStore().getId();
		inventory.sort(Comparator.comparing(func));
	}
}
