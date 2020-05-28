package generic.type28;

import java.util.Arrays;
import java.util.List;

public class GMethod {
	public static void main(String[] args) {
		String s = "string";
		Integer i = 20;
		Float f = 30f;
		printO(s);
		printO(i);
		printO(f);

		System.out.println("==========================");
		printG(s);
		printG(i);
		printG(f);

		System.out.println("==========================");

		String[] strings = { "a", "b", "c", "d" };
		Integer[] interters = { 1, 2, 3, 4, 5 };
		Double[] doubles = { 1d, 2d, 3d, 4d, 5d };
		Object[] objects = { "a", "b", 2, "d", "e" };
		showO(objects);
		showO(strings);
		showO(interters);
		showO(doubles);

		showG(objects);
		showG(strings);
		showG(interters);
		showG(doubles);
		System.out.println("==========================");
	

	}

	
	private static void showO(Object[] objects) {
		for (Object object : objects) {
			System.out.print(object + " ");
		}
		System.out.println();
	}

	private static <E> void showG(E[] element) {
		for (E e : element) {
			System.out.print(e + " ");
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
