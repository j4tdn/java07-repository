package PhuongTrinhBac2.LeNhatPhi_PBT2;

import java.util.Scanner;

public class Ptb2 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		System.out.print("Nhập hệ số bậc 2, a = ");
		int a = ip.nextInt();
		System.out.print("Nhập hệ số bậc 1, b = ");
		int b = ip.nextInt();
		System.out.print("Nhập hằng số tự do, c = ");
		int c = ip.nextInt();
		GiaiPhuongTrinhBac2(a, b, c);
	}

	public static void GiaiPhuongTrinhBac2(int a, int b, int c) {

		if (a == 0) {
			if (b == 0) {
				System.out.println("Phương trình vô nghiệm!");
			} else {
				System.out.println("Phương trình có một nghiệm: " + "x = " + (-c / b));
			}
			return;
		}

		float delta = b * b - 4 * a;
		float x1;
		float x2;

		if (delta > 0) {
			x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
			x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
			System.out.println("Phương trình có 2 nghiệm là: " + "x1 = " + x1 + " và x2 = " + x2);
		} else if (delta == 0) {
			x1 = (-b / (2 * a));
			System.out.println("Phương trình có nghiệm kép: " + "x1 = x2 = " + x1);
		} else {
			System.out.println("Phương trình vô nghiệm!");
		}
	}
}
