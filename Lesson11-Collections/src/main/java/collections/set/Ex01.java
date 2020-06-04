package collections.set;

import java.util.HashSet;

import java.util.Set;

public class Ex01 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("hello");
		set.add("hello");
		System.out.println(set.size());
	}
}
