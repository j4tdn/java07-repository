package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {

	//@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<>();
		//bound, unbound, automatically bound
		digits.add(10);
		digits.add(20);
		digits.add(30);
		for (int i = 0; i < digits.size(); i++) {
			Integer obj = digits.get(i);
			System.out.println(obj);
		}
	}

}
