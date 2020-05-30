package generic.type;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		
		strings.add("Fake Item 01");
		strings.add("Fake Item 02");
		strings.add("Fake Item 03");
		strings.add("a", 2);
		strings.add("a");
		strings.forEach(string->System.out.print(string+" "));
		System.out.println("\n==========");
		strings.remove("a");
		strings.forEach(string->System.out.print(string+" "));
		System.out.println("\n=============");
		System.out.println("size: "+strings.size());
		System.out.println(strings.getClass());
		
		// forEach
		// add(int index, E e)
		// remove(int i)
		// remove(E e)
	}
}
