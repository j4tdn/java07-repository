package bt;

public class Ex07 {
	public static void main(String[] args) {
		String s = "aabbccc";

		int maxOne = 1, maxTwo = 1, count = 1, tempOne = 0, tempTwo = 0, min = 127;

		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
				maxTwo = count;
				if (maxOne < maxTwo) {
					maxOne = maxTwo;
					tempOne = i;
				}
				// System.out.println(maxOne + " " + maxTwo + " : " + tempOne + " : " + tempTwo
				// + " : " + min);
				if (min >= count) {
					min = count;
					tempTwo = i;
				}
				// System.out.println(maxOne + " " + maxTwo + " : " + tempOne + " : " + tempTwo
				// + " : " + min);
				count = 1;
			} else {
				count++;
			}
		}

		System.out.print("Độ dài lớn nhất của dãy con đúng là: " + maxOne + " - ");
		for (int i = tempOne - maxOne + 1; i <= tempOne; i++) {
			System.out.print(s.charAt(i));
		}
		System.out.println("  [" + (tempOne - maxOne + 1) + "]");
		System.out.print("Độ dài nhỏ nhất của dãy con đúng là: " + min + " - ");
		for (int i = tempTwo - min + 1; i <= tempTwo; i++) {
			System.out.print(s.charAt(i));
		}
		System.out.println("  [" + (tempTwo - min + 1) + "]");
	}
}