package exercises.Lesson10_duongchimanh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex01 {
	public static void main(String[] args) {
		int sizeArray = 10;
		List<Integer> numbers = new ArrayList<>();
		createIntegerArray(sizeArray, numbers);
		getUniqueNumber(numbers);
		compareAvg(numbers);
		insertionSort(numbers);
		thirdMaxValue(numbers);
	}

	private static void thirdMaxValue(List<Integer> numbers) {
		int max = numbers.get(numbers.size() - 1);
		int count = 1;
		for (int i = numbers.size() - 1; i >= 0; i--) {
			if (numbers.get(i) < max && count < 3) {
				max = numbers.get(i);
				count += 1;
			}
		}
		System.out.println("\nThird Max Value: " + max);
	}

	private static void insertionSort(List<Integer> numbers) {
		for (int i = 1; i < numbers.size(); i++) {
			int key = numbers.get(i);
			int j = i - 1;
			while (j >= 0 && key < numbers.get(j)) {
				numbers.set(j + 1, numbers.get(j));
				j -= 1;
			}
			numbers.set(j + 1, key);
		}
		System.out.print("Insertion Sort: ");
		numbers.forEach(number -> System.out.print(number + " "));
	}

	private static void compareAvg(List<Integer> numbers) {
		int elements = numbers.size() / 2;
		double sumBefore = 0, sumAfter = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (i < elements) {
				sumBefore += numbers.get(i);
			} else {
				sumAfter += numbers.get(i);
			}
		}
		System.out.println();
		if (sumAfter < sumBefore) {
			System.out.println("The average of 5 elements first is greater than the average of 5 elements second!");
		} else {
			if (sumAfter == sumBefore) {
				System.out.println("The average of 5 elements first is equals to the average of 5 elements second!");
			} else {
				System.out.println("The average of 5 elements first is smaller than the average of 5 elements second!");
			}
		}
	}

	private static void getUniqueNumber(List<Integer> numbers) {
		List<Integer> uniqueNumber = new ArrayList<>();
		for (Integer number : numbers) {
			if (!contains(number, numbers)) {
				uniqueNumber.add(number);
			}
		}
		System.out.print("Unique Number of Array: ");
		uniqueNumber.forEach(number -> System.out.print(number + " "));

	}

	private static boolean contains(Integer num, List<Integer> numbers) {
		int count = 0;
		for (int number : numbers) {
			if (number == num) {
				count += 1;
			}
		}
		if (count > 1) {
			return true;
		}
		return false;
	}

	private static void createIntegerArray(int sizeArray, List<Integer> numbers) {
		Random rand = new Random();
		for (int i = 0; i < sizeArray; i++) {
			numbers.add(rand.nextInt(10));
		}
		System.out.print("Elements of Array: ");
		for (int number : numbers) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
}
