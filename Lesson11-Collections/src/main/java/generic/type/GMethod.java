package generic.type;

import java.util.Arrays;

public class GMethod {
	public static void main(String[] args) {
		String s = "string";
		Integer i = 20;
		float f = 30f;

		printO(s);
		printO(i);
		printO(f);
		System.out.println("===============");
		printG(s);
		printG(i);
		printG(f);
		System.out.println("===============");
		String[] strings = { "a", "b", "c" };
		Integer[] integers = { 1, 2, 3, 4, 5 };
		Double[] doubles = { 1d, 2d, 3d, 4d, 5d };
		Object[] objects = { "a", 2, 3d, 4, "e" };

		showO(strings);
		showO(integers);
		showO(doubles);
		showO(objects);
		System.out.println("\n===============");
		showG(strings);
		showG(integers);
		showG(doubles);
		showG(objects);
		
	}
	//mang array
	//Object[] cha cua string,integer,
	private static void showO(Object[] objects) {
		for (Object o : objects) {
			System.out.print(o + " ");
		}
	}

	private static <E> void showG(E[] elements) {
		for (E e : elements) {
			System.out.print(e + " ");
		}
	}

	private static void printO(Object o) {
		System.out.println(o);
	}

	// G kieu du lieu generic object
	private static <G> void printG(G o) {
		System.out.println(o);
	}
	
	
}
