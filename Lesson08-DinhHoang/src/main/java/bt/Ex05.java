package bt;

import java.util.ArrayList;

public class Ex05 {
	public static void main(String[] args) {
		String S1 = "BCKABCEDEABC";
		String S2 = "ABCEDCBBCK";
//		System.out.println(charSequence(S1));
//		System.out.println(charSequence(S2));

		ArrayList<String> list = new ArrayList<String>();
		longestString(S1, S2, list);
		System.out.println(list);

		int count = 0;
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() > count) {
				count = list.get(i).length();
				temp = i;
			}
		}
		System.out.println("Xâu con chung dài nhất là: " + list.get(temp));
	}

	private static void longestString(String s1, String s2, ArrayList<String> list) {
		int tempOne = 0;
		while (tempOne < s1.length()) {
			int maxOne = 1;
			int tempTwo = 0;
			while (tempTwo < s2.length()) {
				int maxTwo = 1;
				if (s1.charAt(tempOne) == s2.charAt(tempTwo)) {
					maxTwo = check(tempOne, s1, tempTwo, s2, list);
					if (maxOne < maxTwo) {
						maxOne = maxTwo;
					}
				}
				tempTwo += maxTwo;
			}
			tempOne += maxOne;
		}
	}

	private static int check(int tempOne, String s1, int tempTwo, String s2, ArrayList<String> list) {
		String s = String.valueOf(s1.charAt(tempOne));
		int count = 1;
		if (tempOne != s1.length() - 1 && tempTwo != s2.length() - 1) {
			tempOne++;
			tempTwo++;
			while (tempOne < s1.length()) {
				while (tempTwo < s2.length()) {
					if (s1.charAt(tempOne) == s2.charAt(tempTwo)) {
						s += String.valueOf(s1.charAt(tempOne));
						count++;
						tempTwo++;
						break;
					} else {
//						System.out.println(s);
//						System.out.println(count);
						list.add(s);
						return count;
					}
				}
				tempOne++;
			}
		}
//		System.out.println(s);
//		System.out.println(count);
		list.add(s);
		return count;
	}

//	private static ArrayList<String> charSequence(String s) {
//		ArrayList<String> list = new ArrayList<String>();
//		String str = String.valueOf(s.charAt(0));
//		for (int i = 0; i < s.length(); i++) {
//			if (i != s.length() - 1 && s.charAt(i) == (s.charAt(i + 1) - 1)) {
//				str += s.charAt(i + 1);
//				continue;
//			}
//			list.add(str);
//			if (i != s.length() - 1) {
//				str = String.valueOf(s.charAt(i + 1));
//			}
//		}
//		return list;
//	}
}