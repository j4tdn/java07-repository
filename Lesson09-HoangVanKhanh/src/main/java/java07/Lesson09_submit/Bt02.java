package java07.Lesson09_submit;

public class Bt02 {
	public static void main(String[] args) {
		String[] str = { "aa6b54687c6e22h", "0123asda2b3456cde478", "a32a6b345452fdgfd6c6e22h" };
		for (int i = 0; i < str.length; i++) {
			System.out.println(test(str[i]));
		}
	}

	private static int test(String s) {
		String[] integers = s.split("[a-z]+");
		int[] arrInt = new int[integers.length];
		int j = 0;
		while (integers[j].equals("")) {
			j++;
		}
		arrInt[0] = Integer.valueOf(integers[j]);
		int max = arrInt[0];

		for (int i = 1; i < integers.length; i++) {
			arrInt[i] = Integer.valueOf(integers[j]);
			if (max < arrInt[i]) {
				max = arrInt[i];
			}
			j++;
		}
		return max;
	}

}
