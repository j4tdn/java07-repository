package generics.type;

public class GMethod {
	public static void main(String[] args) {
		String s = "string";
		Integer i = 20;
		Float f = 30f;

		printO(s);
		printO(i);
		printO(f);
		System.out.println("====================");

		printG(s);
		printG(i);
		printG(f);
		System.out.println("====================");

		String[] strings = { "1", "a", "b", "c", "d" };
		Integer[] integers = { 1, 2, 3, 4, 5 };
		Double[] doubles = { 1d, 2d, 3d, 4d, 5d };
		Object[] objects = { "a", 2, "c", 4, "e" };

		show(strings);
		show(integers);
		show(doubles);
		show(objects);
		System.out.println("====================");

		showG(objects);
		showG(integers);
		showG(doubles);
		showG(objects);
	}

	private static void printO(Object o) {
		System.out.println(o);
	}

	private static <G> void printG(G g) {
		System.out.println(g);
	}

	private static void show(Object[] objects) {
		for (Object object : objects) {
			System.out.print(object + " ");
		}
		System.out.println();
	}

	private static <E> void showG(E[] elements) {
		for (Object element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}