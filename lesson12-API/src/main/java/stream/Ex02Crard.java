package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Ex02Crard {
	public static void main(String[] args) {
		List<String> first = Arrays.asList("2 cơ", "xì rô", "10 bích");
		List<String> seconder = Arrays.asList("3 cơ", "xì rô", "8 bích");
		List<String> third = Arrays.asList("4 cơ", "xì chuồn", "2 bích");
		// List<String> fourth = Arrays.asList("5 cơ", "xì chuồn","7 bích");
		// bietes laf 2 cơ thì dùng starwwith hoặc content
		List<List<String>> all = Arrays.asList(first, seconder, third);
//		String result = all.stream().flatMap(List -> List.stream()
//				.filter(card -> card.startsWith("2")).
//				collect(Collectors.joining(", ")));
//		System.out.println("result" + result);

		
		System.out.println("==========================");
		//Arrays.stream(squareOf(1,2,3,4)).forEarch(System.out::println);
		
	}

	private static int[] squareOf(int[] number) {
		return Arrays.stream(number).map(num -> num * num).toArray();
	}
	private static List<Integer> squareOf(List<Integer> number) {
		return number.stream().map(num -> num * num).collect(Collectors.toList());
	}
}
