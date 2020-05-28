package generic.type28;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String>  strings = new FakeList<>();
		strings.add("Fake Item 01");
		strings.add("Fake Item 02");
		strings.add("Fake Item 03");
		System.out.println(strings.size());
		System.out.println("index 2 " + strings.get(2));
		strings.set(2, "Real Item");
		System.out.println(strings.getClass());
		System.out.println("==========================");
		for(int i = 0; i < strings.size();i++) {
			System.out.println(strings.get(i)+" ");
		}
	}
}
