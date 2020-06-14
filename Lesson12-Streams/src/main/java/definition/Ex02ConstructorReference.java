package definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import beans.Apple;
import functions.TriFunction;

public class Ex02ConstructorReference {

	public static void main(String[] args) {
		Supplier<LinkedHashMap<String, Integer>> supplier = LinkedHashMap::new;
		LinkedHashMap<String, Integer> linkedHash = supplier.get();
		
		String student = "join-adam-anne";
		String[] filtered = Pattern.compile("-").splitAsStream(student)
			.filter(s->s.startsWith("a"))
			.toArray(String[]::new);
		
		Arrays.stream(filtered).forEach(System.out::println);
		
		//constructor with no variable
		Supplier<Apple> no = Apple::new;
		no.get();
		
		Function<String, Apple> func = Apple::new;
		func.apply("Blue");
		
		List<String> colors = Arrays.asList("Black", "White");
		
		List<Apple> apples = map(colors, Apple::new);
		apples.forEach(System.out::println);
		
		TriFunction<String, String, Integer, Apple> triFunction = Apple::new;
		Apple a = triFunction.apply("Blue", "VN", 100);
		System.out.println(a);
	}
	
	//map string(origin) -> apple
	private static <T,R> List<R> map(List<T> ts, Function<T, R> function){
		List<R> list = new ArrayList<>();
		for(T t : ts) {
			list.add(function.apply(t));
		}
		
		return list;
	}
}
