package generics.type;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("A");
		strings.add("b");
		strings.add("s");
		strings.add("k");
		strings.add("C", 3);

		System.out.println(strings.size());
//		System.out.println(strings.getClass());
//		strings.set(2, "new item");
//		System.out.println(strings.get(2));
//		for(int i=0;i<strings.size();i++) {
//			System.out.println(strings.get(i));
//		}
		strings.forEach(string -> {
			System.out.print(string + " ");
		});
		System.out.println("Create then e :" + count(strings,s-> "A".compareTo(s)==0));

	}

	private static <E> int count(FakeList<E> list, Predicate<E> pre) {
		int cout = 0;
		for (int i = 0; i < list.size(); i++) {
//			E item = list.get(i);
//			if(list.get(i).compareTo(e)>0) {
//				cout++;
//			}
			if(pre.test(list.get(i))) {
				cout++;
			}
		}
		return cout;
	}
	
		

	// code ham forEach
	// Add(int index,E e)
	// remove(int i)
	// remove(E e)

}
