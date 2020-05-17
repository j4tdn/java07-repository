package collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> digit = new ArrayList<Integer>();
		Collections.sort(digit,(i1,i2)->i1.compareTo(i2));
		Collections.reverse(digit);
		
	}

	private static List<Integer> random(int n) {
		List<Integer> digits = new ArrayList<Integer>();
		Random rd = new Random();
		int i = 0;
		while (i < size) {
			int rand = demo.nextInt(10) + 1;
			if (!digit.contains(rand)) {
				digit.add(rand);
				i++;
			}
		}

	}
}
