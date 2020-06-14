package view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01AppleView {
	
	private static AppleService service = new AppleServiceImpl();
	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();
		show(inventory);
	
		System.out.println("=====================");
		List<Apple> expected = service.filter(inventory, apple -> "green".equals(apple.getColor()));
		
		show(expected);
		
		List<String> contries = map(expected, Apple::getOrigin);
		
		show(contries);
		
		//put definition into practice;
		System.out.println("=====================");
		inventory.sort(Comparator.comparing(Apple::getColor));
		show(inventory);
		
		Map<String, Integer> apples = inventory.stream().collect(Collectors.toMap(Apple::getColor, Apple::getWeight, (e1,e2) -> e1));
		apples.forEach((t,u) -> System.out.println(t +"=>" + u));
	}
	
	
	private static <T,R> List<R> map(List<T> ts, Function<T, R> function){
		List<R> list = new ArrayList<>();
		for(T t : ts) {
			list.add(function.apply(t));
		}
		
		return list;
	}
	
	private static void show(List<?> inventory) {
		inventory.forEach(System.out::println);
	}
}
