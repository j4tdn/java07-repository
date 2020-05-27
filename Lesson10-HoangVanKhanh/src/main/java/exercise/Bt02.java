package exercise;

import java.util.Scanner;

public class Bt02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] numbers = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 1, 9, 0, 9 }, { 2, 9, 6, 5 }, { 1, 2, 4, 5 } };
		int[][] numbers2 = { { 1, 2, 3, 4 }, { 5, 0, 8, 7 }, { 1, 9, 0, 9 }, { 2, 0, 6, 5 }, { 1, 2, 4, 5 } };

		
//		for (int i = 0; i < numbers2.length; i++) {
//			for (int j = 0; j < numbers[i].length; j++) {
//				if (numbers2[i][j] == 0) {
//					tmpI[ii] = i;
//					tmpJ[ii++] = j;
//				}
//			}
//		}
		number0(numbers2);
		outputArray(numbers2);
		System.out.println("==========================");
		number0(numbers);
		outputArray(numbers);

		
	}

	// private static void inputArray(int[][] numbers,int m,int n) {
//		Scanner sc=new Scanner(System.in);
//		m=sc.nextInt();
//		n=sc.nextInt();
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.println("Nhap phan tu thu["+i+","+j+"]:");
//				numbers[i][j]=sc.nextInt();
//			}
//		}
//	}
	private static void outputArray(int[][] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	private static void out(int[][] numbers, int tempI, int tempJ) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				if (i == tempI || j == tempJ) {
					numbers[i][j] = 0;
				}
			}
		}
		// outputArray(numbers);

	}

//	private static void outArr(int[] numbers) {
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.print(numbers[i] + " ");
//		}
//		System.out.println();
//	}

	private static void number0(int[][] numbers) {
		int[] tmpI = new int[numbers.length];
		int[] tmpJ = new int[numbers[0].length];
		int ii = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				if (numbers[i][j] == 0) {
					tmpI[ii] = i;
					tmpJ[ii++] = j;
				}
			}
		}
		for (int i = 0; i < ii; i++) {
			out(numbers, tmpI[i], tmpJ[i]);

		}

	}

}
