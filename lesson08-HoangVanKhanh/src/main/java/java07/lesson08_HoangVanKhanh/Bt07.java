package java07.lesson08_HoangVanKhanh;

public class Bt07 {
	public static void main(String[] args) {
		String s = "aaabaaabbaaaaa";

		int maxOne = 0, maxTwo = 0, count = 1, tempOne = 1, tempTwo = 1, min = 999;

		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1) {
				if (s.charAt(i) != s.charAt(i - 1)) {
					if (min >= count) {
						min = count;
						tempTwo = i;
					}

				} else {
					maxTwo = count;
					if (maxOne < maxTwo) {
						maxOne = maxTwo;
						tempOne = i;
					}

				}
			} else if (s.charAt(i) == s.charAt(i + 1)) {
				count++;
			} else {
				maxTwo = count;
				if (maxOne < maxTwo) {
					maxOne = maxTwo;
					tempOne = i;
				}
				if (min >= count) {
					min = count;
					tempTwo = i;
				}

				count = 1;
			}
		}

		System.out.print("Độ dài lớn nhất của dãy con đúng là: " + maxOne + " - ");
		for (int i = tempOne - maxOne + 1; i <= tempOne; i++) {
			System.out.print(s.charAt(i));
		}
		System.out.print("\nĐộ dài nhỏ nhất của dãy con đúng là: " + min + " - ");
		for (int i = tempTwo - min + 1; i <= tempTwo; i++) {
			System.out.print(s.charAt(i));
		}
	}

}
