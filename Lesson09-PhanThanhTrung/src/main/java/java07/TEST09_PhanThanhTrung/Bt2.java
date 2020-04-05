package java07.TEST09_PhanThanhTrung;

public class Bt2 {
	public static void main(String[] args) {
		String[] s = { "abcd123ads43", "kqw5673a5f7g77" };
		for (int i = 0; i < s.length; i++) {
			System.out.println(number(s[i]));
		}
	}

	private static int number(String str) {
		String[] numbers = str.split("[a-z]+");
		int[] arr = new int[numbers.length];
		int j = 0;
		while (numbers[j].equals("")) {
			j++;
		}
		arr[0] = Integer.valueOf(numbers[j]);
		int max = arr[0];

		for (int i = 1; i < numbers.length; i++) {
			arr[i] = Integer.valueOf(numbers[j]);
			if (max < arr[i]) {
				max = arr[i];
			}
			j++;
		}
		return max;
	}
}
