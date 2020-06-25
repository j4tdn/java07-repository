package date01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex01 {
	public static Random rd = new Random();

	public static void main(String[] args) {
		List<Integer> list = creat(5);
		list.forEach(System.out::println);

		System.out.println("==========================");
		System.out.println(secondBig(list));
		System.out.println("==========================");
		System.out.println(BCNN_Array(list));
		System.out.println("==========================");
		total(list);
	}

	public static List<Integer> creat(int n) {
		List<Integer> digits = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			digits.add(rd.nextInt(91) + 10);
		}
		return digits;

	}

	public static Integer UCLN(int first, int second) {
		if (first == second) {
			return first;
		}
		if (first > second) {
			return UCLN(first - second, second);
		} else {
			return UCLN(first, second - first);
		}
	}

	public static Integer BCNN(int first, int second) {

		return first * second / UCLN(first, second);

	}

	public static Integer BCNN_Array(List<Integer> digits) {
		int tmp = BCNN(digits.get(0), digits.get(1));
		for (int i = 2; i < digits.size(); i++) {
			tmp = BCNN(tmp, digits.get(i));
		}
		return tmp;
	}

	public static int secondBig(List<Integer> digits) {

		int secondBig = 0;
		digits.sort((i1, i2) -> i2.compareTo(i1));

		for (int i = 1; i < digits.size(); i++) {
			if (!digits.get(i).equals(digits.get(0))) {
				secondBig = digits.get(i);
				break;
			}
		}
		return secondBig;

	}

	public static void total(List<Integer> digits) {
		System.out.println(digits.get(0) + digits.size() - 1);
	}
}
