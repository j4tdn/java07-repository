package generic.type;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings= new FakeList<>();
		strings.add("Fake Item 01");
		strings.add("Fake Item 02");
		strings.add("Fake Item 03");
		System.out.println("Index 2: "+strings.get(2));
		strings.set(2, "new Item");
		System.out.println("Index 2: "+strings.get(2));
		System.out.println("size: "+ strings.size());
		System.out.println("class: "+ strings.getClass());
		
		for (int i = 0; i < strings.size(); i++) {
			System.out.print(strings.get(i)+", ");
		}
		
		// Kiểm tra tại lớp
		// forEach fakeItem
		// add(int index, E e)
		// remove(int i)
		// remove(E e)
	}
}
