package generic.type;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("Fake Item 01");
		strings.add("Fake Item 02");
		strings.add("Fake Item 03");

		System.out.println(strings.size());
		strings.set(2, "real");
		System.out.println("index2: " + strings.get(2));
		System.out.println("class: " + strings.getClass());
		for(int i=0;i<strings.size();i++) {
			System.out.println(strings.get(i));
		}
	}

}
// code forEach
//add(1,E)
//remove(int,i)
//remove(1,E)