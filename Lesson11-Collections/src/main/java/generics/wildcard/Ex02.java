package generics.wildcard;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<String> first = Arrays.asList("a","b","c","d");
		List<String> second= Arrays.asList("v","s","f","d");
		
		first.addAll(second);
		//coppy(first, second);
		first.forEach(item -> System.out.print(item + " "));
	}
	private static <E> void coppy(List<E> first,List<? extends E> second) {
		first.addAll(second);
	}

}
