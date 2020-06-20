package bt01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Bt01 {
	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n =:");
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			int numbers = rd.nextInt(90) + 10;
			if(list.indexOf(numbers)==-1) {
			list.add(numbers);}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.print("Boi chung nho nhat cua cac phan tu trong mang : ");
		System.out.println(listBcnn(list));
		System.out.println("==========================");
		System.out.print("Tong phan tu dau va phan tu cuoi trong mang : ");
		System.out.println(sum(list));
		System.out.println("=============================");
		System.out.print("Phan tu lon thu 2 trong mang : ");
		System.out.println(number(list));

	}

	public static int BCNN(int a, int b) {
		int tmp1 = a;
		int tmp2 = b;
		while (tmp1 != tmp2) {
			if (tmp1 > tmp2) {
				tmp1 -= tmp2;
			} else {
				tmp2 -= tmp1;
			}
		}
		int uscln = tmp1;
		return (a * b) / uscln;
	}

	public static int listBcnn(ArrayList<Integer> list) {
		int tmp = BCNN(list.get(0), list.get(1));
		if (list.size() == 1) {
			tmp = list.get(0);
		}
		if (list.size() == 2) {
			tmp = BCNN(list.get(0), list.get(1));
		} else {

			for (int i = 2; i < list.size(); i++) {
				tmp = BCNN(tmp, list.get(i));
				tmp = BCNN(list.get(0), list.get(1));
			}
		}
		return tmp;

	}

	public static int number(ArrayList<Integer> list) {
		Collections.sort(list);
		return list.get(list.size()-2);
	}
	
	public static int sum(ArrayList<Integer> list) {
		
		return list.get(0) + list.get(list.size()-1);
	}

	

}
