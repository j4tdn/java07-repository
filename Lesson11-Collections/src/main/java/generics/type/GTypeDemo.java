package generics.type;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("hello");
		strings.add("Kai");
		strings.add("Do");

		System.out.println("size: " + strings.size());
		strings.set(2, "DODODO");
		System.out.println("Index 2: " + strings.get(2));
		System.out.println("class: " + strings.getClass());

		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
	}
}