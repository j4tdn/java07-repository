package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex02Card {
	public static void main(String[] args) {
		List<String> first = Arrays.asList("2 cơ", "Xì rô", "10 bích");
		List<String> second = Arrays.asList("3 cơ", "Xì rô", "8 bích");
		List<String> third = Arrays.asList("4 cơ", "Xì chuồn", "2 bích");
		// List<String> fourth = Arrays.asList("5 cơ", "Xì bích" ,"7 rô");

		List<List<String>> all = Arrays.asList(first, second, third);
		String result = all.stream().flatMap(list -> list.stream())
			.filter(card -> card.startsWith("2"))
			.collect(Collectors.joining(", "));
		System.out.println(result);
		
		Arrays.stream(squareOfArray(1, 2 , 3 ,4 , 5)).forEach(System.out::println);
	}
	
	private static int[] squareOfArray(int... arr) {
		int[] result = Arrays.stream(arr).map(e -> e * e).toArray();
		return result;
	}
	
	private static List<Integer> squareOfList(List<Integer> list) {
		return list.stream().map(num -> num * num).collect(Collectors.toList());
	}
}
