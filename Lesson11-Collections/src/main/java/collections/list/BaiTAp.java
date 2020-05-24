package collections.list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BaiTAp {
	public static void main(String[] args) {
		Random demo = new Random();
		int[] numbers = new int[5];
		for (int i = 0; i < numbers.length;) {
			int rand = demo.nextInt(10) + 1;
			if (!containt(numbers, rand)) {
				numbers[i] = rand;
				i++;
			}
		}
		System.out.println("==============================");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));

		System.out.println("\n==============================");
		List<Integer> digit = new ArrayList<>();
		System.out.println(digit.size());
		
		int size = 5;
		int count = 0;
		while (count < size) {
			int rand = demo.nextInt(10) + 1;
			if (!digit.contains(rand)) {
				digit.add(rand);
				count++;
			}
		}
		System.out.println("123"+digit.size());
		//digit.forEach(digits -> System.out.println(digits + " "));
		loop(digit);
		
	}

	private static void loop(List<Integer> digits)  {
		//for each
		System.out.println("==============forEach=============");
		for(int digit : digits) {
			System.out.print(digit+" ");
		}
		
		//for index
		System.out.println("\n============Index===============");
		for(int i = 0 ; i < digits.size();i++) {
			System.out.print(digits.get(i)+" ");
		}
		
		//itertor, interable
		System.out.println("\n==============itertor=============");
		Iterator<Integer> iterator = digits.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		
	}

	private static boolean containt(int[] numbers, int rand) {
		for (int number : numbers) {
			if (rand == number) {
				return true;
			}
		}
		return false;
	}
}
