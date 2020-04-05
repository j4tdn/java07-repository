package test02;

public class Ex02 {
	public static void main(String[] args) {
		String[] strArr = { "dsaddasd", "aa6b326c6e22h" };
		showArr(getMaxNumberOfArr(strArr));
	}

	private static int getMaxNumber(String str) {

		if (str.length() == 0) {
			return 0;
		}
		String[] charArr = str.split("");
		String strNumber = "";
		for (int i = 0; i < charArr.length; i++) {
			if (!charArr[i].matches("\\d")) {
				charArr[i] = " ";
			}
			strNumber += charArr[i];
		}
		if (strNumber.matches("[\\s]+")) {
			return 0;
		} else {
			String numbers[] = strNumber.trim().split("[\\s]+");
			int max = Integer.parseInt(numbers[0]);
			for (String number : numbers) {
				max = Integer.parseInt(number) > max ? Integer.parseInt(number) : max;
			}
			return max;
		}
	}

	private static int[] getMaxNumberOfArr(String[] arr) {
		int[] results = new int[arr.length];
		int index = 0;
		for (String item : arr) {
			results[index] = getMaxNumber(item);
			index++;
		}
		return results;
	}

	private static void showArr(int[] results) {
		for (int item : results) {
			System.out.println(item);
		}
	}
}
