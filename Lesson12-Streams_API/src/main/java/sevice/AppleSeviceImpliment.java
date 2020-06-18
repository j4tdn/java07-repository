package sevice;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import AppleDao.AppleDao;
import AppleDao.AppleDaoImpl;
import Predicate.StrategyPredicate;
import beans.Apple;

public class AppleSeviceImpliment implements AppleSevice {
	private static AppleSevice service = (AppleSevice) new AppleSeviceImpliment();

	public static void main(String[] args) {
		List<Apple> inventory = service.getAll();

		List<Apple> greenApple = service.filter(inventory, apple -> "green".equals((apple).getColor()));

		show(inventory);
		System.out.println("======================");
		show(greenApple);
		System.out.println("======================");
//		
//		Function<Apple, String> function = new Function<Apple, String>() {
//
//			@Override
//			public String apply(Apple t) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//		
		List<String> countries = map(greenApple, Apple::getOrigin);
		show(countries);
		System.out.println("======================");

		// put definition into practice
		inventory.sort(Comparator.comparing(Apple::getColor));
		show(inventory);
		System.out.println("======================");

		Map<String, Integer> map = inventory.stream()
				.collect(Collectors.toMap(Apple::getColor, Apple::getWeight, (i1, i2) -> i1));
		map.forEach(new BiConsumer<String, Integer>() {

			@Override
			public void accept(String k, Integer v) {
				System.out.println(k + "=>" + v);
			}
		});
		System.out.println("======================");
	}

	private static <T, R> List<R> map(List<T> ts, Function<T, R> function) {
		List<R> results = new ArrayList<>();
		for (T t : ts) {
			results.add(function.apply(t));
		}
		return results;
	}

	private static void show(List<?> inventory) {
		inventory.forEach(System.out::println);
	}

	@Override
	public List<Apple> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Apple> filter(List<Apple> inventory, StrategyPredicate<Apple> predicate) {
		// TODO Auto-generated method stub
		return null;
	}
}
