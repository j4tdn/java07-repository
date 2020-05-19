package ex1;

public class Ex04 {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 5, 8, 9, 10, 5, 8, 9, 12, 7, 7, 6};
		System.out.println(thirdMax(numbers));;
	}
	
	private static int max(int[] numbers) {
		int max = numbers[0];
		for (int number : numbers) {
			if (max < number) {
				max = number;
			}
		}
		return max;
	}
	
	private static int secondMax(int[] numbers) {
		int thirdMax = numbers[0];
		for (int number : numbers) 	{
			if (number != max(numbers) && number != thirdMax(numbers) && thirdMax < number) {
				thirdMax = number;
			}
		}
		return thirdMax;
	}
}
