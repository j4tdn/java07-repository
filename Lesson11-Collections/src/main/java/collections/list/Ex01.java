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
		for(int i=0;i<digits.size();i++) {
			Object object =digits.get(i);
			Integer.parseInt(object.toString());
			System.out.println();
		}
	}
}
