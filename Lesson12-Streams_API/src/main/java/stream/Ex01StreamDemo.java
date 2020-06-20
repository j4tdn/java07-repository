package stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Apple;
import sevice.AppleSevice;
import sevice.AppleSeviceImpliment;

public class Ex01StreamDemo {
	private static AppleSevice sevice = new AppleSeviceImpliment();

	public static void main(String[] args) {
		List<Apple> inventory = sevice.getAll();
		Set<String> result = inventory.stream().filter(a -> a.getWeight() > 150).limit(2).map(Apple::getOrigin)
				.collect(Collectors.toSet());
		result.forEach(System.out::println);
	}

}
