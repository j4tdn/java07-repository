package generics.type;

import java.util.List;

public class GMethod {
	public static void main(String[] args) {
		String s = "String";
		Integer i = 20;
		float f = 30f;

		printO(s);
		printO(i);
		printO(f);
		System.out.println("=============");
		printG(s);
		printG(i);
		printG(f);
		System.out.println("=================");
		String[] strings = { "a", "b", "c", "d" };
		Integer[] integers = { 1, 2, 3, 4, 5 };
		Double[] doubles = { 1.2d, 2.3d, 4.0d };
		Object[] objects = { "a", 2, "d", 8, "t" };

		show(objects);
		show(doubles);
		show(integers);
		show(strings);
		System.out.println("================");
		showE(objects);
		showE(doubles);
		showE(integers);
		showE(strings);
		
	}

	private static void printO(Object o) {
		System.out.println(o);

	}

	private static <G> void printG(G g) {
		System.out.println(g);

	}

	private static void show(Object[] objects) {
		for (int i = 0; i < objects.length; i++) {
			System.out.print(i);
		}
		System.out.println();
	}

	private static <E> void showE(E[] elements) {
		for (E e : elements) {
			System.out.print(e + " - ");
		}
		System.out.println();
	}

}
