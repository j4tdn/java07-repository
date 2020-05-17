package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List digits = new ArrayList();
		digits.add(10);
		digits.add(20);
		digits.add(30);
		digits.add("4.0");
		digits.add(new Object());
		for (int i = 0; i < digits.size(); i++) {
			Object obj = digits.get(i);
			System.out.println(Integer.parseInt(obj.toString()));
		}
	}

}
