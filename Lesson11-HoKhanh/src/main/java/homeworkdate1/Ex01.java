package homeworkdate1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex01 {
	public static void main(String[] args) {
		List<Integer> numbers = random(12);
		int temp = numbers.get(0);
		numbers.forEach(System.out::println);
		for (Integer number : numbers) {
			temp = leastCommonMultiple(temp, number);
		}
		System.out.println("boi chung nho nhat cua mang la: " + temp);
		System.out.println("so lon thu 2 cua mang la: "+secondLargestNumber(numbers));
		System.out.println("tong so dau va cuoi cua mang la: "+sumOfFirstAndLastNumber(numbers));
		
	}
	
	private static int sumOfFirstAndLastNumber(List<Integer> numbers) {
		return (numbers.get(0)+numbers.get(numbers.size()-1));
	}

	private static int secondLargestNumber(List<Integer> numbers) {
		List<Integer> results =new ArrayList<>();
		results.addAll(numbers);
		int count = 1;
		Collections.sort(results);
		for (int i = 0; i < results.size() - 1; i++) {
			if (results.get(i) != results.get(i + 1)) {
				count++;
			}
			if (count == 2) {
				return results.get(i + 1);
			}
		}
		return results.get(results.size() - 1);
	}

	private static int greatestCommonDivisor(int firstNumber, int secondNumber) {
		if (secondNumber == 0) {
			return firstNumber;
		}
		return greatestCommonDivisor(secondNumber, firstNumber % secondNumber);
	}

	private static int leastCommonMultiple(int firstNumber, int secondNumber) {
		return firstNumber * secondNumber / greatestCommonDivisor(firstNumber, secondNumber);
	}

	private static List<Integer> random(int n) {
		List<Integer> digits = new ArrayList<>();
		Random rd = new Random();
		int i = 0;
		while (i < n) {
			digits.add(rd.nextInt(91) + 10);
			i++;
		}
		return digits;
	}
}
