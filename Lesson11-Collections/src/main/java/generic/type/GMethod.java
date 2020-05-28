package generic.type;

public class GMethod {
	public static void main(String[] args) {
		String s = "string";
		Integer i = 20;
		Float f = 30f;

		printO(s);
		printO(i);
		printO(f);
		System.out.println("==========");
		printG(s);
		printG(i);
		printG(f);

		System.out.println("==========");

		String[] strings = { "a", "b", "c", "d" };
		Integer[] integers = { 1, 2, 3, 4 };
		Double[] doubles = { 1d, 2d, 3d, 4d };
		Object[] objects = { "a", 2, "c", 4, "e" };

		showO(strings);
		showO(integers);
		showO(doubles);
		showO(objects);
		System.out.println("==========");
		showE(strings);
		showE(integers);
		showE(doubles);
		showE(objects);
	}

	private static void showO(Object[] objects) {
		for (Object obj : objects) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}

	private static <E> void showE(E[] e) {
		for (E element : e) {
			System.out.print(element + " ");
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