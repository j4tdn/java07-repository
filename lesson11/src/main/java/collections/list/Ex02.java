package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<Integer> digits=new ArrayList<>();
		digits.add(1);
		digits.add(123);
		for(int i=0;i<digits.size();i++) {
			
			System.out.println(digits.get(i));
		}
	}
}
