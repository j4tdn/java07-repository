package definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import beans.Apple;
import function.TriFunction;

public class Ex02ConstructorReference {
	public static void main(String[] args) {
		Supplier<LinkedHashMap<String, Integer>> supplier = LinkedHashMap::new;

		LinkedHashMap<String, Integer> map = supplier.get();
		String students = "join-adam-anne";
		String[] filtered = Pattern.compile("-").splitAsStream(students).filter(s -> s.startsWith("a"))
				.toArray(String[]::new);

		Arrays.stream(filtered).forEach(System.out::println);

		// Constructor with no variables
		Supplier<Apple> no = Apple::new;
		no.get();

		//
		Function<String, Apple> func = Apple::new;
		func.apply("blue");
		
		List<Apple> apple=map(Arrays.asList("black","white"), Apple::new);
		apple.forEach(System.out::println);
		//show(countries);
		
		TriFunction<String, String, Integer,Apple> triFunc=Apple::new;
		Apple a=triFunc.apply("black", "VN", 100);
		System.out.println(a);
		
	}
	public static<T,R> List<R> map(List<T> ts,Function<T ,R> function) {
		List<R> result=new ArrayList<>();
		for(T t:ts) {
			result.add(function.apply(t));
		}
		return result;
		
	}

}
