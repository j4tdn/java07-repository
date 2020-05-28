package generic.type;

import java.util.ArrayList;
import java.util.Arrays;

public class GMethod {
	public static void main(String[] args) {
		String s = "string";
		Integer i = 20;
		Float f = 30f;
		System.out.println(s);
		System.out.println(i);
		System.out.println(f);
		printO(s);
		printO(f);
		printO(i);
		System.out.println("==================");
		printG(s);
		printG(f);
		printG(i);
		String[] strings = { "a", "b", "c", "d" };
		Integer[] integers = { 1, 2, 3, 4, 5 };
		Double[] doubles = { 1d, 2d, 3d, 4d, 5d };
		Object[] object = { "a", 2, "c", 4, "e" };
		show(strings);
		show(integers);
		show(doubles);
		show(object);
		System.out.println();
		System.out.println("=================");
		showG(strings);
		showG(integers);
		showG(doubles);
		showG(object);
		
	
	}

	private static void show(Object[] objects) {
		for (Object object : objects) {
			System.out.print(object + " ");
		}
	}
	private static<E> void showG(E[] element) {
		for (Object object : element) {
			System.out.print(object + " ");
		}
	}


	private static void printO(Object o) {

		System.out.println(o);
	}

	private static <G> void printG(G g) {// 1 kiểu dư liệu chung,object.

		System.out.println(g);
	}
}
