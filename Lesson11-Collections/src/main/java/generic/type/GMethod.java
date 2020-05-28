package generic.type;

import java.util.Arrays;

public class GMethod {
	public static void main(String[] args) {
		String s = "string";
		Integer i = 10;
		Float f = 30f;

		printO(s);
		printO(i);
		printO(f);
		System.out.println("=======================");

		printG(s);
		printG(i);
		printG(f);

		System.out.println("=======================");

		String[] strings = { "a", "d", " c", "b", "e" };
		Integer[] integers = { 12, 2, 3, 1, 62 };
		Double[] doubles = {1d, 5d, 12d, 9d};
		Object[] objects = {12, 3, 5, "d", "v"};
		
		showO(strings);
		showO(objects);
		showO(integers);
		showO(doubles);
		
		System.out.println("=======================");

		showG(strings);
		showG(objects);
		showG(integers);
		showG(doubles);
		
		System.out.println("=======================");
		
	}
	
	private static void showO(Object[] objects) {
		for(Object o : objects) {
			System.out.print(o + "  ");
		}
		System.out.println();
	}
	
	private static <E> void showG(E[] elements) {
		for(E element : elements) {
			System.out.print(element + "  ");
		}
		System.out.println();
	}

	private static void printO(Object o) {
		System.out.println(o);
	}

	private static <G> void printG(G g) {
		System.out.println(g);
	}

}
