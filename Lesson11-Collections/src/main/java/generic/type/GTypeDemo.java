package generic.type;

public class GTypeDemo {
	
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		
		strings.add("aaaaa");
		strings.add("bbbbb");
		strings.add("ccccc");
		System.out.println("size: " + strings.size());
		strings.set(2, "real item");
		System.out.println("index 2: " + strings.get(2));
		System.out.println("class: " + strings.getClass());
		System.out.println("==============================");
		
		for(int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		
		// forEach
		// add(i,e)
		// remove(i)
		// remove(e);
	}

}
