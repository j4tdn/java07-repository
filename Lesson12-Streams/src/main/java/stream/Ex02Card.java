package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02Card {
	public static void main(String[] args) {
		List<String> first = Arrays.asList("2 co", "Xi ro", "10 bich");
		List<String> second = Arrays.asList("3 co", "Xi co", "8 bich");
		List<String> third = Arrays.asList("4 co", "Xi chuon", "2 bich");
		// List<String> fourth = Arrays.asList("5 co", "Xi bich", "7 ro");

		List<List<String>> all = Arrays.asList(first, second, third);
		String result = all.stream().flatMap(list -> list.stream()).filter(card -> card.startsWith("2"))
				.collect(Collectors.joining(", "));
		System.out.println("result: " + result);

		System.out.println("=================================");
		Arrays.stream(squareOf(1, 2, 3, 4, 5)).forEach(System.out::println);
	}

	private static int[] squareOf(int... numbers) {
		return Arrays.stream(numbers).map(number -> number * number).toArray();
	}

	private static List<Integer> squareOf(List<Integer> numbers) {
		return numbers.stream().map(number -> number * number).collect(Collectors.toList());
	}
}
