package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> digits=random(5);
		Collections.sort(digits,(i1,i2)->i1.compareTo(i2));
		Collections.reverse(digits);
		digits.forEach(digit->System.out.print(digit+" "));
	}

	private static  List<Integer> random(int n) {
		List<Integer> digits=new ArrayList<>();
		Random rd=new Random();
		int i=0;
		while(i<n) {
			int rand =rd.nextInt(10)+1;
			if(!digits.contains(rand)) {
				digits.add(rand);
				i++;
			}
		}
		return digits;
	}
}
