package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> digits = random(5);
		
		Collections.sort(digits, (i1,i2) -> i2.compareTo(i1));
		Collections.reverse(digits);
		
		digits.forEach(num -> System.out.print(num + "   "));
		
		//remove by index
		//digits.remove(0);
		
		//remove by element
		//digits.remove(new Integer(2));
		
		//remove the odd numbers
		digits.removeIf((digit) -> digit % 2 == 0);
		digits.set(0, 99);
		
		System.out.println("\n==========================");
		digits.forEach(num -> System.out.print(num + "   "));
	}
	
	private static List<Integer> random(int size){
		Random rd = new Random();
		List<Integer> digits = new ArrayList<>();
		int i = 0;
		while( i < size) {
			int number = rd.nextInt(5) + 1;
			if(!digits.contains(number)) {
				digits.add(number);
				i++;
			}
		}
		return digits;
	}

}
