package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<>();
		digits.add(10);
		digits.add(20);
		digits.add(30);
		digits.add(40);
		
		// for index
		for (int i = 0; i < digits.size(); i++) {
			System.out.println(digits.get(i));
		}
	}
}
