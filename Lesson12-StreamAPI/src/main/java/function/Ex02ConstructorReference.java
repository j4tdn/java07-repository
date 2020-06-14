package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import beans.Apple;

public class Ex02ConstructorReference {
	public static void main(String[] args) {
		Supplier<LinkedHashMap<String, Integer>> supplier =LinkedHashMap::new;//()-> LinkedHashMap();
		LinkedHashMap<String, Integer> map = supplier.get();
		
		String students= "join-adam-anne";
		String[] filtered= Pattern.compile("-").splitAsStream(students)
				.filter(s->s.startsWith("a")).toArray(String[]::new);
		
		Arrays.stream(filtered).forEach(System.out::println);
		
		// constructor with no variables
		Supplier<Apple> no = Apple::new;
		// no.get();
		
		Function<String, Apple> func = Apple::new;
		func.apply("blue");
		
		//map String(origin) to Apple
		List<Apple> apples= map(Arrays.asList("black","white"), Apple::new);
		apples.forEach(System.out::println);
		
		TriFunction<String, String, Integer, Apple> triFunction= Apple::new;
		Apple a= triFunction.apply("yellow", "VietNam", 220);
		
		System.out.println(a);
	}
	private static <T,R> List<R> map(List<T> ts, Function<T, R> func){
		List<R> result= new ArrayList<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;
	}
}
