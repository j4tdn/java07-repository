package generic.type;

import generic.classs.FakeList;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");
		System.out.println("size: " + strings.size());
		strings.set(2, "newTtem");
		System.out.println("Index 2: " + strings.get(2));
		System.out.println("class: " + strings.getClass());
		
		for (int i = 0; i < strings.size(); i++) {
			System.out.print(strings.get(i) + " ");
		}
		
		strings.add(2, "newItem2");
		strings.remove(2);
		strings.remove("newTtem");
		strings.forEach(s -> System.out.println(s + " "));
	}
}
