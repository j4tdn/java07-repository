package bt01;

public class Bt03 {
	public static void main(String[] args) {
		String str = "xyz";
		permutation(str);
	}

	private static void permutation(String str) {
		String[] s = str.split("");
		permuteHelper(s, 0);
	}

	private static void permuteHelper(String[] s, int index) {
		if (index >= s.length - 1) {
			for (int i = 0; i < s.length - 1; i++) {
				System.out.print(s[i]);
			}
			if (s.length > 0) {
				System.out.print(s[s.length - 1]);
			}
			System.out.println();
			return;
		}
		for (int i = index; i < s.length; i++) {
			String t = s[index];
			s[index] = s[i];
			s[i] = t;
			permuteHelper(s, index + 1);
			t = s[index];
			s[index] = s[i];
			s[i] = t;
		}
	}

}
