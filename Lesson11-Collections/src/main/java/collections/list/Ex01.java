package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//before v1.5
		List digits = new ArrayList();
		digits.add(10);
		digits.add(11);
		digits.add(12);
		//error
		digits.add("14");
		digits.add(new Object());
		
		for (int i = 0; i < digits.size(); i++) {
			Object object = digits.get(i);
			System.out.println(Integer.parseInt(object.toString()));
		}
		
	}
}
