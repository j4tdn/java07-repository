package date01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập độ dài mảng: ");
		int index = Integer.parseInt(sc.nextLine());
		System.out.println("=========================");
		List<Integer> numbers = createData(index);
		System.out.println("Mãng số ngẫu nhiên:");
		numbers.forEach(number -> System.out.print(number + " "));
		System.out.println("\n=========================");
		int result = leastCommonMultiple(numbers);
		System.out.println("Bội chung nhỏ nhất của các phần tử trong mảng là: " + result);
		System.out.println("=========================");
		int secondLargest = secondLargest(numbers);
		System.out.println("Tìm phần tử lớn nhất thứ hai trong mảng: " + secondLargest);
		System.out.println("=========================");
		int sum = total(numbers);
		System.out.println("Tổng của phần tử đầu và phần tử cuối của mảng: " + sum);
	}

	private static List<Integer> createData(int index) {
		List<Integer> listNumbers = new ArrayList<>();
		Random rd = new Random();
		while (index > 0) {
			int number = rd.nextInt(91) + 10;
			if (contains(listNumbers, number)) {
				listNumbers.add(number);
				index--;
			}
		}
		return listNumbers;
	}

	private static boolean contains(List<Integer> numbers, int number) {
		for (int digit : numbers) {
			if (digit == number) {
				return false;
			}
		}
		return true;
	}

	private static int leastCommonMultiple(List<Integer> numbers) {
		int result = numbers.get(0);
		for (int i = 1; i < numbers.size(); i++) {
			result = (result * numbers.get(i)) / greatestCommonDivisor(result, numbers.get(i));
		}
		return result;
	}

	private static int greatestCommonDivisor(int before, int after) {
		int result = 1;
		for (int i = before; i > 0; i--) {
			if (before % i == 0 && after % i == 0) {
				result = i;
				break;
			}
		}
		return result;
	}

	private static int secondLargest(List<Integer> numbers) {
		List<Integer> tmpNumber = new ArrayList<>(numbers);
		tmpNumber.sort((n1, n2) -> n1.compareTo(n2));
		int secondLargest = tmpNumber.get(tmpNumber.size() - 1);
		for (int i = tmpNumber.size() - 2; i >= 0; i--) {
			if (tmpNumber.get(i) != secondLargest) {
				secondLargest = tmpNumber.get(i);
				return secondLargest;
			}
		}
		return 0;
	}

	private static int total(List<Integer> numbers) {
		if (numbers.size() == 1) {
			return numbers.get(numbers.size() - 1);
		}
		int sum = numbers.get(0) + numbers.get(numbers.size() - 1);
		return sum;
	}
}