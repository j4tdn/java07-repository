package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings({ "rawtypes" })

		List<Object> digits = new ArrayList<Object>();
		digits.add(10);
		digits.add(20);
		digits.add(30);
		for (int i = 0; i < digits.size(); i++) {
			Object object = digits.get(i);
			System.out.println(Integer.parseInt(object.toString()));

		}

	}
}
