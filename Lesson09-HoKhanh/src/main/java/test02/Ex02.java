package test02;

public class Ex02 {
	public static void main(String[] args) {
		String[] wordNumbers = { "aa6b546c6e22h", "01a2b3456cde478", "aa6b326c6e22h" };
		for (int i = 0; i < wordNumbers.length; i++) {
			System.out.println(check(wordNumbers[i]));
		}
	}

	private static int check(String s) {
		String[] numberStrings = s.split("[a-z]+");
		int[] numbers = new int[numberStrings.length];
		int j = 0;
		while (numberStrings[j].equals("")) {
			j++;
		}
		numbers[0] = Integer.valueOf(numberStrings[j]);
		int max = numbers[0];

		for (int i = 1; i < numberStrings.length; i++) {
			numbers[i] = Integer.valueOf(numberStrings[j]);
			if (max < numbers[i]) {
				max = numbers[i];
			}
			j++;
		}
		return max;
	}
}
