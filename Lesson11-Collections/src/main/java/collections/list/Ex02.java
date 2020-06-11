package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<>();
		// bound, unbound, automatically bound: 1.5
		digits.add(10);
		digits.add(20);
		digits.add(30);
		
		// digits.add("4.0");
		// digits.add(new Object());
		
		// for index
		for (int i = 0; i < digits.size(); i++) {
			System.out.println(digits.get(i));
		}
		
	}

}
