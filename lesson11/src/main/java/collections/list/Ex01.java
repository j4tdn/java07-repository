package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List digits=new ArrayList();
		digits.add(1);
		digits.add(123);
		for(int i=0;i<digits.size();i++) {
			Object object=digits.get(i);
			System.out.println(Integer.parseInt(object.toString())+" ");
		}
	}
}
