package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02Card {
	public static void main(String[] args) {
		List<String> first = Arrays.asList("2 co", "Xi ro", "10 bich");
		List<String> second = Arrays.asList("3 co", "Xi chuon", "8 bich");
		List<String> third = Arrays.asList("4 co", "Xi bich", "2 bich");
		// List<String> fourth = Arrays.asList("5 co", "Gia co", "7 chuon");

		List<List<String>> all = Arrays.asList(first, second, third);
		String result = all.stream().flatMap(list -> list.stream()).filter(card -> card.startsWith("2"))
				.collect(Collectors.joining(", "));
		System.out.println(result);

		Arrays.stream(squareOf(1, 2, 3, 4)).forEach(System.out::println);
	}

	private static int[] squareOf(int... numbers) {
		return Arrays.stream(numbers).map(num -> num * num).toArray();
	}

	private static List<Integer> squareOf(List<Integer> numbers) {
		return numbers.stream().map(num -> num * num).collect(Collectors.toList());
	}
}
