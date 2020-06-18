package composing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import bean.Apple;
import bean.Store;
import service.AppleService;
import service.AppleServiceimpl;

public class Ex02Function {
	private static AppleService service= new AppleServiceimpl();
	public static void main(String[] args) {
		Function<String, String> f = s -> s + s;
		Function<String, Integer> g= s->s.length();
		Function<String, Integer> r=g.compose(f);
		System.out.println(r.apply("xinchao"));
		//sort list of apples by store id
		List<Apple> inventory = service.getAll();
//		Function<Apple, Store> storeFunc = Apple::getStore;
//		Function<Store, String> storeIdFunc = Store::getId;
		Function<Apple, String> func= a->a.getStore().getId();
		inventory.sort(Comparator.comparing(/*storeFunc.andThen(storeIdFunc)*/func));
	}
}
