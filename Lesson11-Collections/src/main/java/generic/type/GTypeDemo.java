package generic.type;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		System.out.println("size: " + strings.size());
		System.out.println("class: " + strings.getClass());
		strings.add("Hi");
		strings.add("Hello");
		// forEach
		// add(int index, E e)
		// remove(int i)
		// remove(E e)
	}
}