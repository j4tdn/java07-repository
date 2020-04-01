package java07.lesson08_NguyenPhanThanhNhat;

import java.util.Scanner;

public class Bai4 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap 2 so tu nhien:");
		System.out.println("Nhap N: ");
		int n = ip.nextInt();
		System.out.println("Nhap M: ");
		int m = ip.nextInt();
		System.out.print("Kiem tra M va N co la so nguyen to tuong duong hay khong: ");
		System.out.println(isEquivalentPrimeNumbers(primeFactorization(n), primeFactorization(m)));
	}

	private static StringBuilder primeFactorization(int n) {
		StringBuilder primeString = new StringBuilder();
		String s;
		int i = 2, old = 0;
		while (n > 1) {
			if (n % i == 0) {
				n /= i;
				if (i != old) {
					s = Integer.toString(i);
					primeString.append(s);
				}
				old = i;
			} else {
				i++;
			}
		}
		return primeString;
	}

	private static boolean isEquivalentPrimeNumbers(StringBuilder primeStringOfN, StringBuilder primeStringOfM) {
		return (primeStringOfN.toString().compareTo(primeStringOfM.toString()) == 0) ? true : false;
	}
}
