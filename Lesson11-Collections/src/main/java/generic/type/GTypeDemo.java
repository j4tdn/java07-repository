package generic.type;

import java.util.List;
import java.util.function.Predicate;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		
		strings.add("A");
		strings.add("D");
		strings.add("S");
		strings.add("K", 2);
		strings.forEach(string->System.out.print(string+" "));
		System.out.println("\n==========");
//		strings.remove("a");
//		strings.forEach(string->System.out.print(string+" "));
//		System.out.println("\n=============");
//		System.out.println("size: "+strings.size());
//		System.out.println(strings.getClass());
		System.out.println(">E ="+count(strings,s->"E".equals(s) ));
		
		
	}
	private static <E extends Comparable<E>>int count(FakeList<E> list,Predicate<E> pre){
		int count = 0;
		for(int i =0;i<list.size();i++) {
//			if(list.get(i).compareTo(e)>0) {
//				count++;
//			}
			if(pre.test(list.get(i))) {
				count++;
			}
			
//			E item = list.get(i);
//			if(item instanceof String ) {
//				if(((String) item).compareTo((String) e)>0) {
//					count++;
//				}
//			}
		}
		return count;
	}
}
