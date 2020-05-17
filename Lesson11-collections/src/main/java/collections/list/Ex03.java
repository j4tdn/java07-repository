package collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Ex03 {
	public static void main(String[] args) {
		Random rd = new Random();
		int[] number = new int[5];
		for (int i = 0; i < number.length;) {
			int rand = rd.nextInt(10) + 1;
			if (!contains(number, rand)) {
				number[i] = rand;
				i++;
			}
		}

	}

	private static boolean contains(int[] number, int rand) {
		for (int numbe : number) {
			if (numbe == rand) {
				return true;
			}
		}
		return false;
	}

	private static void loop(List<Integer> digits) {
		// for index
		for (int i = 0; i < digits.size(); i++) {
			System.out.println(digits.get(i) + " ");
		}
		// for each
		for (int digit : digits) {
			System.out.println(digit + " ");
		}
		// itertor,iterable
		java.util.Iterator<Integer> iterator = digits.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
