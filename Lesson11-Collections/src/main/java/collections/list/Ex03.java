package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.print.attribute.standard.NumberUpSupported;

public class Ex03 {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		List arrInt = Ex03.Arr(5);
		loop(arrInt);
	}

	public Ex03() {

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List Arr(int number) {
		Random rd = new Random();
		List tmp = new ArrayList<>();
		int count = 0;
		int value;
		boolean flag;
		while (count < number) {

			flag = false;
			value = (int) (rd.nextInt(10) + 1);
			for (int i = 0; i < tmp.size(); i++) {

				if (((Integer) tmp.get(i)).intValue() == value) {

					flag = true;
					break;

				}

			}
			if (!flag) {

				tmp.add(value);
				count++;

			}
		}
		return tmp;
	}

	private static void loop(List<Integer> nunbers) {
		System.out.println("\n=================Index================");
		for (int i = 0; i < nunbers.size(); i++) {
			System.out.print(nunbers.get(i) + " ");
		}
		System.out.println("\n===============forEach================");
		for (int number : nunbers) {
			System.out.print(number + " ");

		}
		System.out.println("\n==============Interator================");
		Iterator<Integer> iterator = nunbers.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}
