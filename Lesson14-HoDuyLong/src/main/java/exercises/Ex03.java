package exercises;

public class Ex03 {
	public static void main(String[] args) {
		String input = "xyz";
		permutation(input, 0, input.length() - 1);
	}

	private static void permutation(String s, int l, int r) {
		if (l == r) {
			System.out.println(s);
		} else {
			for (int i = l; i <= r; i++) {
				s = swap(s, l, i);
				permutation(s, l + 1, r);
				s = swap(s, l, i);
			}
		}
	}

	private static String swap(String s, int a, int b) {
		char[] charArray = s.toCharArray();
		char temp;
		temp = charArray[a];
		charArray[a] = charArray[b];
		charArray[b] = temp;

		return String.valueOf(charArray);
	}
}
