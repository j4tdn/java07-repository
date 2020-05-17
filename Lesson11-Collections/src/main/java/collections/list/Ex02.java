package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// before v1.5
		List digits = new ArrayList();
		// bound, unbound, automated bound : v1.5
		digits.add(new Integer(10));
		// digits.add(11);
		// digits.add(12);

		// error
		//digits.add("14");
		//digits.add(new Object());

		for (int i = 0; i < digits.size(); i++) {
			Object object = digits.get(i);
			System.out.println(Integer.parseInt(object.toString()));
		}
		
		//Since v1.5
		List<Integer> digit = new ArrayList<>();
		digit.add(10);
		
		//error
		//digit.add("14");
		//digit.add(new Object());

		for (int i = 0; i < digit.size(); i++) {
			Integer object = digit.get(i);
			System.out.println(object);
		}
	}
}
