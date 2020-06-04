package generic.willcard;

public class Solution {
	public static void main(String[] args) {
		String A = "aaaabb";
		String B = "aaabbb";
		System.out.println(buddyStrings(A, B));
	}

	public static boolean buddyStrings(String A, String B) {
		int count = 0;
		int[] index = new int[3];
		if (A.length() != B.length()) {
			return false;
		} else {
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) != B.charAt(i)) {
					index[count] = i;
					count += 1;
					if (count > 2) {
						return false;
					}
				}
			}
			if (count == 0) {
				for (int i = 0; i < A.length() - 1;i++) {
					if(A.charAt(i) != A.charAt(i + 1) || A.length() > 2) {
						return false;
					}
				}
				return true;
			} else {
				if (A.charAt(index[0]) == B.charAt(index[1]) && A.charAt(index[1]) == B.charAt(index[0])) {
					return true;
				}
			}
		}
		return false;
	}
}
