package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> digits = random(5);
		
		Collections.sort(digits, (i1,i2) -> i2.compareTo(i1));
		Collections.reverse(digits);
		
		digits.forEach(num -> System.out.print(num + "   "));
	}
	
	private static List<Integer> random(int size){
		Random rd = new Random();
		List<Integer> digits = new ArrayList<>();
		int i = 0;
		while( i < size) {
			int number = rd.nextInt(10) + 1;
			if(!digits.contains(number)) {
				digits.add(number);
				i++;
			}
		}
		return digits;
	}

}
