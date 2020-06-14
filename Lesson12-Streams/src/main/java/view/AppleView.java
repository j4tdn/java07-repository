package view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import beans.Apple;
import service.AppleService;
import service.AppleServiceImpl;

public class AppleView {
	private static AppleService service = new AppleServiceImpl();
	public static <T> void main(String[] args) {
		List<Apple> inventory = service.getAll();
		
		List<Apple> expected = service.filter(inventory, a -> a.getWeight() > 100);
		List<Apple> expectedGreenApples = service.filter(inventory, a -> "green".equals(a.getColor()));
		
		List<String> countries = map(expectedGreenApples, Apple::getOrigin);
		//show(countries);
		
		//put definition into 
		inventory.sort(Comparator.comparing(Apple::getColor));
		Map<String, Integer> map = inventory.stream().collect(Collectors.toMap(Apple::getColor, Apple::getWeight, (a1, a2) -> a1));
		
		show(inventory);
		map.forEach(new BiConsumer<String, Integer>() {

			@Override
			public void accept(String t, Integer u) {
				System.out.println(t + "->" + u);
			}
			
		});
	}
	
	private static <T> void show(List<?> inventory) {                                 
		inventory.forEach(System.out::println);
	}
	
	private static <T, R> List<R> map(List<T> ts, Function<T, R> func) {
		List<R> result = new ArrayList<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;
	}
}
