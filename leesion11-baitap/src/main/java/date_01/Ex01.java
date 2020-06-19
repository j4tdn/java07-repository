package date_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex01 {

	public static void main(String[] args) {
		List<Integer> digits = random(10);
		Collections.reverse(digits);
		
		digits.forEach(number -> System.out.print(number + " "));
		System.out.println("\n=====Second max element=====");
		secondMaxElement(digits);
		System.out.println("===Total to firt and end element======");
		totalFirtEndElement(digits);
		
	}

	private static List<Integer> random(int index) {
		List<Integer> numbers = new ArrayList<>();
		Random rd = new Random();
		do {
			int rand = rd.nextInt(100);
			numbers.add(rand);
		} while (numbers.size() < index);
		return numbers;
	}
	private static void totalFirtEndElement(List<Integer> digits) {
		System.out.println(digits.get(0) + digits.get(digits.size() -1));
	}
	private static void secondMaxElement(List<Integer> digits) {
		int max = Integer.MIN_VALUE  ;
		int seconds = Integer.MIN_VALUE ;	
		for (Integer numbers : digits)
			if (numbers > max) {
				seconds = max;
				max = numbers;
			} else if (numbers != max && numbers > seconds) {
				seconds = numbers;
			}
		System.out.println( seconds);
	}

}
