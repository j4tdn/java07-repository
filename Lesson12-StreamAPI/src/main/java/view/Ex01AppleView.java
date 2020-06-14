package view;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import beans.Apple;
import predicate.StrategyPredicate;
import service.AppleService;
import service.AppleServiceImpl;

public class Ex01AppleView {
	private static AppleService service = new AppleServiceImpl();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		StrategyPredicate<Apple> test = (Apple a) -> {
			return true;
		};

		// anonymous class
		StrategyPredicate<Apple> predicate = a->a.getWeight()>100;


		List<Apple> expectedGreenApple = service.filter(inventory, a->"green".equals(a.getColor()));
		List<String > countries= map(expectedGreenApple, Apple::getColor);
		show(expectedGreenApple);
		
		// put definition into pratice
		System.out.println("=============================");
		inventory.sort(Comparator.comparing(Apple::getColor));
		show(inventory);
		System.out.println("================");
		Map<String, Integer> map= inventory.stream()
				.collect(Collectors
						.toMap(Apple::getColor, Apple::getWeight, (e1,e2)-> e1));
		map.forEach((k,v)-> System.out.println(k+" -> "+v));
		show(inventory);
	}

	private static <T,R> List<R> map(List<T> ts, Function<T, R> func){
		List<R> result= new ArrayList<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;
	}
	
	
	
	private static void show(List<Apple> inventory) {
		// Function<Apple, String> func= Apple::getColor;
		inventory.forEach(System.out::println);;
	}
}
