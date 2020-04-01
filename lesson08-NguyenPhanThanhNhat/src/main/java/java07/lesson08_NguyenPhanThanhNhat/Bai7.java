package java07.lesson08_NguyenPhanThanhNhat;

import java.util.Scanner;

public class Bai7 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String s = ip.nextLine();
		int[] indexes = new int[2];

		indexes = findIndexOfMaxSubString(s);
		String maxSubString = s.substring(indexes[0], indexes[1] + 1);
		System.out.print("Độ dài lớn nhất của dãy con đúng : " + maxSubString.length());
		System.out.print(" " + maxSubString);
		System.out.println(" [" + +indexes[0] + "]");

		indexes = findIndexOfMinSubString(s);
		String minSubString = s.substring(indexes[0], indexes[1] + 1);
		System.out.print("Độ dài nhỏ nhất của dãy con đúng : " + minSubString.length());
		System.out.print(" " + minSubString);
		System.out.println(" [" + +indexes[0] + "]");
	}

	private static int[] findIndexOfMaxSubString(String s) {
		int[] indexes = new int[2];
		int len = 1, max = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				len++;
				if (len > max) {
					max = len;
					indexes[1] = i + 1;
					indexes[0] = i + 1 - (max - 1);
				}
			} else {
				len = 1;
			}
		}
		return indexes;
	}

	private static int[] findIndexOfMinSubString(String s) {
		int[] indexes = new int[2];
		int len = 1, min, minStart = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				minStart++;
			} else {
				break;
			}
		}
		min = minStart;
		for (int i = minStart; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				len++;
			} else {
				if (len < min) {
					min = len;
					indexes[1] = i;
					indexes[0] = i - (min - 1);
				} else {
					len = 1;
				}
			}
		}
		return indexes;
	}
}
