package stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex02Car {

	public static void main(String[] args) {
		List<String> first = Arrays.asList("2 co", "xi ro", "10 bich");
		List<String> second = Arrays.asList("3 co", "5 bich", "10 ro");
		List<String> third = Arrays.asList("2 ro", "Xi ro", "10 bich");
		List<String> forth = Arrays.asList("5 co", "Xi bich", "10 bich");

		List<List<String>> all = Arrays.asList(first, second, third);

		String result = all.stream().flatMap(list -> list.stream()).filter(card -> card.startsWith("2"))
				.collect(Collectors.joining(", "));

		System.out.println("Result " + result);

		System.out.println("==============================");

		Arrays.stream(squareOf(1, 2, 3, 4, 5)).forEach(System.out::println);

		System.out.println("==============================");
		
	}

	private static int[] squareOf(int... numbers) {

		return Arrays.stream(numbers).map(num -> num * num).toArray();
	}

	private static List<Integer> squareOf(List<Integer> numbers) {

		return numbers.stream().map(num -> num * num).collect(Collectors.toList());
	}

}
