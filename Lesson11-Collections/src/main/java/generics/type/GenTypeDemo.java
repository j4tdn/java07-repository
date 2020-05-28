package generics.type;




public class GenTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings=new FakeList<>();
		strings.add("fake item01");
		strings.add("fake item02");
		strings.add("fake item03");
		strings.add("fake item04");
		
		System.out.println(strings.size());
		System.out.println(strings.getClass());
		strings.set(2, "new item");
		System.out.println(strings.get(2));
		for(int i=0;i<strings.size();i++) {
			System.out.println(strings.get(i));
		}
		
	}
	//code ham forEach
	//Add(int index,E e)
	//remove(int i)
	//remove(E e)

}
