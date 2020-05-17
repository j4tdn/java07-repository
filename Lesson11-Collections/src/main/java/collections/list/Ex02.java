package collections.list;

import java.util.ArrayList;
import java.util.List;

//kdl tho :rawtype

public class Ex02 {

	// @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		List<Integer> digits = new ArrayList<>();
		digits.add(new Integer(10));
		digits.add(20);
		digits.add(30);

		// for index
		for (int i = 0; i < digits.size(); i++) {
			Integer object = digits.get(i);
			//Integer.parseInt(object.toString())
			System.out.println(object);
		}
	}
}
