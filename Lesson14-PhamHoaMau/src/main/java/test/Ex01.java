package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex01 {
	public static void main(String[] args) {
		int size = 100;
		List<Integer> numbers = new ArrayList<>();
		List<Integer> uniqueNumbers = new ArrayList<>();
		numbers = createArray(size);
		show(numbers);
		uniqueNumbers = getUniqueNumber(numbers);
		System.out.println("\nUnique Elements:");
		show(uniqueNumbers);
		uniqueNumbers = getNonUniqueNumber(numbers);
		System.out.println("\nNon Unique Elements:");
		show(uniqueNumbers);
	}

	private static List<Integer> getNonUniqueNumber(List<Integer> numbers) {
		Set<Integer> nonUniqueNumbers = new HashSet<>();
		for (Integer number : numbers) {
			if(!isUniqueNumber(number, numbers)) {
				nonUniqueNumbers.add(number);
			}
		}
		return nonUniqueNumbers.stream().collect(Collectors.toList());
	}

	private static List<Integer> getUniqueNumber(List<Integer> numbers) {
		List<Integer> uniqueNumbers = new ArrayList<>();
		for (Integer number : numbers) {
			if(isUniqueNumber(number, numbers)) {
				uniqueNumbers.add(number);
			}
		}
		return uniqueNumbers;
	}

	private static boolean isUniqueNumber(Integer number, List<Integer> numbers) {
		int count = 0;
		for (Integer num : numbers) {
			if(num == number) {
				count ++;
			}
		}
		if(count > 1) {
			return false;
		}
		else {
			return true;
		}
	}


	private static void show(List<Integer> numbers) {
		for (Integer number : numbers) {
			System.out.print(number + " ");
		}
	}

	private static List<Integer> createArray(int size) {
		Random rand = new Random();
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			numbers.add(rand.nextInt(20) + 1);
		}
		return numbers;
	}
}	
