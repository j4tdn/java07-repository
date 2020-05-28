package generic.type;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		
		strings.add("Fake Item 01");
		strings.add("Fake Item 02");
		strings.add("Fake Item 03");
		
		
		System.out.println("size: "+strings.size());
		System.out.println(strings.getClass());
	}
}
