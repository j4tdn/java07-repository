package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ex03 {
	public static void main(String[] args) {
		createArrayList();
		findApple();
	}
	private static void loop(List<Integer> digits) {
		// for index
		System.out.println("============Index============");
		for (int i = 0; i < digits.size(); i++) {
			System.out.print(digits.get(i) + " ");
		}
		//for each
		System.out.println("\n============For each============");
		for (Integer digit : digits) {
			System.out.print(digit + " ");
		}
		
		//iterator, iterable
		System.out.println("\n============Iterator============");
		Iterator<Integer> iterator = digits.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
	private static void findApple() {
		List<String> fruits = new ArrayList<>();
		fruits.add("Tao My");
		fruits.add("Tao Tau");
		fruits.add("Tao VN");
		fruits.add("Nho");
		fruits.add("Le");
		
		System.out.print("\nFruit is Tao: ");
		for (String fruit : fruits) {
			if(fruit.contains("Tao")) {
				System.out.print(fruit + ", ");
			}
		}
	}
	private static void createArrayList() {
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
		//System.out.println(digits);
		loop(digits);
	}
}
