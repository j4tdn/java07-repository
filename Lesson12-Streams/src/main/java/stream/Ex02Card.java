package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02Card {
	public static void main(String[] args) {
		List<String> first = Arrays.asList("2 cơ", "Xì rô", "10 bích");
		List<String> second = Arrays.asList("3 cơ", "Xì cơ", "8 bích");
		List<String> third = Arrays.asList("4 cơ", "Xì chuồn", "2 bích");
//		List<String> fourth = Arrays.asList("5 cơ", "Xì bích", "5 bích");

		List<List<String>> all = Arrays.asList(first, second, third);
		String result = all.stream().flatMap(List -> List.stream()).filter(card -> card.startsWith("2"))
				.collect(Collectors.joining(", "));
		System.out.println("result : " + result);
		System.out.println("========================");
		Arrays.stream(squareOf(1, 2, 3, 4, 5)).forEach(System.out::println);
		System.out.println("========================");
		List<Integer> numbers = squareOf(Arrays.asList(1, 2, 3, 4, 5));
		numbers.forEach(System.out::println);
	}

	private static List<Integer> squareOf(List<Integer> numbers) {
		return numbers.stream().map(number -> number * number).collect(Collectors.toList());
	}

	private static int[] squareOf(int... numbers) {
		return Arrays.stream(numbers).map(number -> number * number).toArray();
	}
}