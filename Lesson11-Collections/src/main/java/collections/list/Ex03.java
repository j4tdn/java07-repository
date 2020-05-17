package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ex03 {
	 
	public static void main(String[] args) {
		List<Integer> numbers = createList();
		
		numbers.forEach(num -> System.out.print(num + " "));
		System.out.println("\n=============================");
		
		loop(numbers);
	}
	
	private static void loop(List<Integer> digits) {
		//for index
		System.out.println("===========Index=============");
		for(int i = 0; i < digits.size(); i++) {
			System.out.print(digits.get(i) + " ");
		}
		System.out.println("\n============Each=============");
		//for each
		for(int num : digits) {
			System.out.print(num + " ");
		}
		System.out.println("\n===========Iterator==========");
		// iterator, iterable
		Iterator<Integer> iterator =  digits.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
	
	private static List<Integer> createList(){
		Random ran = new Random();
		List<Integer> listNumber = new ArrayList<>();
		
		int size = 5;
		int count = 0;

		while(count < size) {			
			int number = 1 + ran.nextInt(10);
			if(!listNumber.contains(number)) {
				listNumber.add(number);	
				count++;
			}
		}
		return listNumber;
		}
		

	private static boolean isContain(int number, int[] numbers) {
		for(int num : numbers) {
			if(number == num) {
				return true;
			}
		}
		return false;
	}
}
