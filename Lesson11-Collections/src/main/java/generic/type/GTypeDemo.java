package generic.type;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();

		strings.add("Fake Item 01");
		strings.add("Fake Item 02");
		strings.add("Fake Item 03");
		strings.set(2, "Fake Item 3");
		System.out.println("size : " + strings.size());
		System.out.println("class: " + strings.getClass());
		System.out.println("Index 2:" + strings.get(2));
		
		for(int i=0;i<strings.size();i++) {
			System.out.println(strings.get(i));
		}
	}
}
