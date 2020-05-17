package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ex03 {
	public static void main(String[] args) {
		int[] numbers = new int[5];
		Random rd = new Random();
		
		for (int i = 0; i < numbers.length;) {
			int rand = rd.nextInt(10) + 1;
			if (!contains(numbers, rand)) {
				numbers[i] = rand;
				i++;
			}
		}
		System.out.println("================");
		Arrays.stream(numbers).forEach(num->System.out.print(num+" "));
		System.out.println();
		System.out.println("================");
		List<Integer> digits =new ArrayList<>();
		
		int size= 5;
		int count =0;
		while(count<size) {
			int rand=rd.nextInt(10)+1;
			if(!digits.contains(rand)) {
				digits.add(rand);
				count++;
			}
		}
		digits.forEach(digit->System.out.print(digit+" "));
		loop(digits);
	}
	
	private static void loop(List<Integer>digits) {
		//for index
		System.out.println("\n========Index========");
		for(int i=0;i<digits.size();i++) {
			System.out.print(digits.get(i)+" ");
		}
		//for each
		System.out.println("\n======Foreach==========");
		for(Integer digit:digits) {
			System.out.print(digit+" ");
		}
		//iterator, iterable
		System.out.println("\n=========Iterator=======");
		Iterator<Integer> iterator =digits.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
	}

	private static boolean contains(int[] numbers, int rand) {
		for (int number : numbers) {
			if (number == rand) {
				return true;
			}
		}
		return false;
	}
}
