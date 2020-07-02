import java.util.Arrays;
import java.util.List;

public class Bai1 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 5, 5, 3, 1 };
		int[] uniqueNumbers = getUniqueNumbers(numbers);
		System.out.println("Unique Numbers: ");
		Arrays.stream(uniqueNumbers).distinct().forEach(number -> System.out.print(number + "  "));
		System.out.println("\nRemaining Numbers:");
		getRemainingNumbers(numbers, uniqueNumbers);
	}

	private static void getRemainingNumbers(int[] numbers, int[] uniqueNumbers) {
		int[] result = new int[numbers.length];
		int i = 0;
		for (int number : numbers) {
			if (!exist(uniqueNumbers, number)) {
				result[i] = number;
				i++;
			}
		}
		Arrays.stream(result).distinct().forEach(number -> System.out.print(number + "  "));
	}

	private static boolean exist(int[] numbers, int num) {
		for (int number : numbers) {
			if (number == num) {
				return true;
			}
		}
		return false;
	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;

		for (int number : numbers) {
			if (isUnique(numbers, number)) {
				result[index++] = number;
			}
		}

		for (int out = 0; out < numbers.length; out++) {
			int count = 1;
			for (int in = 0; in < numbers.length; in++) {
				if ((in != out) && (numbers[in] == numbers[out])) {
					count++;
					break;
				}
			}
			if (count == 1) {
				result[index++] = numbers[out];
			}
		}

		return Arrays.copyOfRange(result, 0, index);
	}

	private static boolean isUnique(int numbers[], int input) {
		int count = 0;
		for (int number : numbers) {
			if (number == input) {
				count++;
				if (count > 1) {
					return false;
				}
			}
		}
		return true;
	}
}
