package collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) { 
		List<Integer> digits = random(5);
		
		Collections.sort(digits, (i1, i2) -> i2.compareTo(i1));
		
		Collections.reverse(digits);
		
		digits.forEach(digit -> System.out.print(digit + " "));
	}

	private static List<Integer> random(int n) {
		List<Integer> digits = new ArrayList<>();
		Random rand = new Random();
		int count = 0;
		while(count < 5) {
			int number = rand.nextInt(10) + 1;
			if(!digits.contains(number)) {
				digits.add(number);
				count ++;
			}
		}
		return digits;
	}
}
