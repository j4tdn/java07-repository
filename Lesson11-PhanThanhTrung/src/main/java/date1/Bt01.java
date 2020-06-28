package date1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bt01 {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		creatArr(numbers);
		numbers.forEach(System.out::println);

		System.out.println("Boi chung nho nhat: " + BCNN(numbers));
		System.out.println("So lon thu 2: " + secondNumber(numbers));
		System.out.println("Tong so dau va so cuoi cua mang: " + sum(numbers));
	}

	private static void creatArr(List<Integer> numbers) {
		Random rd = new Random();
		System.out.println("Nhap so luong phan tu cua mang: ");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		do {
			numbers.add(rd.nextInt(91) + 10);
			n--;
		} while (n > 0);

	}

	private static int UCLN(int a, int b) {
		int resutl = 0;
		for (int i = a; i > 0; i--) {
			if (a % i == 0 && b % i == 0) {
				resutl = i;
				break;
			}
		}
		return resutl;

	}

	private static long BCNN(List<Integer> numbers) {
		long result = numbers.get(0);
		for (int i = 1; i < numbers.size(); i++) {
			result = result * numbers.get(i) / UCLN((int) result, numbers.get(i));
		}
		return result;
	}

	private static int secondNumber(List<Integer> numbers) {
		List<Integer> num = new ArrayList<>(numbers);// copy mang numbers
		num.sort((o1, o2) -> o1.compareTo(o2));
		for (int i = num.size() - 2; i >= 0; i--) {
			if (num.get(i) != num.get(num.size() - 1)) {
				return num.get(i);
			}

		}
		return 0;
	}

	private static int sum(List<Integer> numbers) {
		if (numbers.size() < 2) {
			return numbers.get(0);
		}
		return numbers.get(0) + numbers.get(numbers.size() - 1);
	}
}
