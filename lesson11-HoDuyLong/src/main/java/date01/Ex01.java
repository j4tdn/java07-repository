package date01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex01 {
	public static void main(String[] args) {
		int length = 7;
		int[] randomNumbers = randomArray(length);

		for (int number : randomNumbers) {
			System.out.print(number + " ");
		}

		int LCM = LCMOfArray(randomNumbers, 0, length);
		long LCMInLong = LCM;

		System.out.println();
		System.out.println("========LCM=========");
		System.out.println(LCMInLong);

		System.out.println("========The Second Largest Element=========");
		System.out.println(theSecondLargest(randomNumbers));

		System.out.println("========The Sum Of The First And The Last Elements=========");
		System.out.println(sumOfTheFirstAndTheLast(randomNumbers));
	}

	private static int[] randomArray(int length) {
		List<Integer> numbers = new ArrayList<>();
		Random rand = new Random();

		for (int i = 0; i < length; i++) {
			int value = rand.nextInt(91) + 10;
			numbers.add(value);
		}

		int[] result = new int[numbers.size()];
		int index = 0;

		for (Integer number : numbers) {
			result[index++] = number;
		}
		return result;
	}

	private static int GCD(int a, int b) {
		if (a < b) {
			return GCD(b, a);
		} else if (a % b == 0) {
			return b;
		} else {
			return GCD(b, a % b);
		}
	}

	private static int LCM(int a, int b) {
		return a * b / GCD(a, b);
	}

	private static int LCMOfArray(int[] arr, int start, int end) {
		if (end - start == 1) {
			return LCM(arr[start], arr[end - 1]);
		} else {
			return LCM(arr[start], LCMOfArray(arr, start + 1, end));
		}
	}

	private static int theSecondLargest(int[] arr) {
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			} else if (arr[i] < first && arr[i] > second) {
				second = arr[i];
			}
		}
		return second;
	}

	private static int sumOfTheFirstAndTheLast(int[] arr) {
		return arr[0] + arr[arr.length - 1];
	}
}
