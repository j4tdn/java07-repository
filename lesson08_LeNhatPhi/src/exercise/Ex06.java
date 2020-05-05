package exercise;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String  str = "123456789101112131415";
		System.out.println("Input position k:");
		int k  = sc.nextInt();
		int index = str.charAt(k);
		System.out.println("Vị tri thứ " + k+": " +(char)index);
	}
}
