package composing_v3;

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
		Function<String,Integer>r = g.compose(f); // compose thif g sẽ thực hiện trước 
		
		System.out.println(r.apply("XINCHAO"));
		
		//sort list of apples bt store id 
		List<Apple> inventory =  service.getAll();
		//là 1 funtion ko thể :: get store :: ...
		inventory.sort(Comparator.comparing(a -> a.getStore().getId()));
		
	}
}
