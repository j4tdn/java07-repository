package collections.set;

import java.util.HashSet;
import java.util.Set;

public class Ex01 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("Hello");// ~map hash key.  set hash object
		set.add("Hello");
		System.out.println(set.size());
	}
}
