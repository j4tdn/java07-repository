package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ex03 {
	/*
	 * Tao danh sach 5 so nguyen [1-10].
	 * Khong trung nhau
	 */
	public static void main(String[] args) {
		Random rd = new Random();
		int[] numbers = new int[5];
		
		for(int i = 0 ; i < numbers.length;) {
			int rand = rd.nextInt(10) + 1;
			if (!contains(numbers, rand)) {
				numbers[i] = rand;
				i++;
			}
		}
		
		System.out.println("=======================");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + "  "));
		
		
		System.out.println("\n======================");
		List<Integer> digits = new ArrayList<>();
		System.out.println("digits size: " + digits.size());
		int size = 5;
		int count = 0;
		while(count < size) {
			int rand = rd.nextInt(10) + 1;
			if (!digits.contains(rand)) {
				digits.add(rand);
				count ++;
			}
		}
		System.out.println("digits size: " + digits.size());
		// digits.forEach(digit -> System.out.print(digit + "  "));
		loop(digits);
	}
	
	private static void loop(List<Integer> digits) {
		// for index
		System.out.println("===========Index============");
		for (int i = 0 ; i < digits.size(); i++) {
			System.out.print(digits.get(i) + "  ");
		}
		
		// for each
		System.out.println("\n===========Each============");
		for(Integer digit: digits) {
			System.out.print(digit + "  ");
		}
		
		// iterator, iterable
		System.out.println("\n===========Interator============");
	 	Iterator<Integer> iterator = digits.iterator();
	 	while(iterator.hasNext()) {
	 		System.out.print(iterator.next() + "  ");
	 	}
	}

	private static boolean contains(int[] numbers, int rand) {
		for (int num: numbers) {
			if (num == rand) {
				return true;
			}
		}
		return false;
	}
}
