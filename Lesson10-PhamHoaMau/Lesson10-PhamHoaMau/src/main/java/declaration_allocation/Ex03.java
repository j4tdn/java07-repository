package declaration_allocation;

import java.util.Arrays;

public class Ex03 {

	public static void main(String[] args) {
		int[] numbers = { 1, 0, 6, 6, 6, 3, 7 };

		distinct(numbers);
		getUniqueNumber(numbers);
		
	}

	private static void getUniqueNumber(int[] numbers) {
		
	}

	private static int[] distinct (int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;
		for (int number : numbers) {
			if(!contain(result, numbers, index)) {
				result[index++] = number;
			}
		}
		
		
		
		return Arrays.copyOfRange(result, 0, index);	
	}

	private static boolean contain(int[] result, int[] numbers, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
