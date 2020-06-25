package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex02Card {
	public static void main(String[] args) {
		List<String> first = Arrays.asList("2 co", "Xi ro", "10 bich");
		List<String> second = Arrays.asList("3 co", "Gia ro", "8 bich");
		List<String> third = Arrays.asList("4 co", "Xi chuon", "2 bich");
		// List<String> fourth = Arrays.asList("5 co", "Xi bich", "7 ro");

		List<List<String>> all = Arrays.asList(first, second, third);
		String result = all.stream().flatMap(list -> list.stream()).filter(card -> card.startsWith("2"))
				.collect(Collectors.joining(","));
		System.out.println(result);

		System.out.println("================");
		Arrays.stream(squareOf(1, 2, 3, 4, 5)).forEach(System.out::println);

	}

	private static int[] squareOf(int... numbers) {
		return Arrays.stream(numbers).map(num -> num * num).toArray();
		// IntStream;

	}

	private static List<Integer> square2(List<Integer> numbers) {
		return numbers.stream().map(num -> num * num).collect(Collectors.toList());

	}
}
