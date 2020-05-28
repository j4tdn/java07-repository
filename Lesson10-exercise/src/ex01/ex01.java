package ex01;

import java.util.Arrays;
import java.util.Random;

public class ex01 {
	public static void main(String[] args) {
		Random rd = new Random();
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rd.nextInt(10);
		}
		for (int i : numbers) {
			System.out.printf(i + " ");
		}
		System.out.println("\n=================");
		
		//CÂU A
		/*
		System.out.println("số chỉ xuất hiện một lần:");
		int[] uniqueNumbers= getUniqueNumbers(numbers);
		Arrays.stream(uniqueNumbers).distinct().forEach(number->System.out.printf(number+" "));
		*/
		//CÂU B
		/*
		System.out.println("\n========================");
		compareValidMedium(numbers);
		*/
		
		//CÂU C
		/*
		System.out.println("\n=====================");
		int[] insertionSortNumbers= insertionSort(numbers);
		Arrays.stream(insertionSortNumbers).forEach(number->System.out.printf(number+" "));
		*/
		
		// CÂU D
		System.out.println("thirdMax: "+ maxThird(numbers));
	}

	private static int maxThird(int[] numbers) {
		int[] sortNumbers= insertionSort(numbers);
		int differentNumber=2, thirdMax=sortNumbers[sortNumbers.length-1]; 
		for (int i = sortNumbers.length-1; i > 0; i--) {
			if (differentNumber>0 && sortNumbers[i]!=sortNumbers[i-1]) {
				thirdMax=sortNumbers[i-1];
				differentNumber--;
			}
		}
		return thirdMax;
	}

	private static int[] insertionSort(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			int key=numbers[i], index=i-1;
			while( index>=0 && key<numbers[index] ) {
				numbers[index+1]=numbers[index];
				index--;
			}
			numbers[index+1]=key;
		}
		return numbers;
	}

	private static void compareValidMedium(int[] numbers) {
		int mediumFirst=0,mediumLast=0;
		for (int i = 0; i < numbers.length; i++) {
			if (i<numbers.length/2) {
				mediumFirst+=numbers[i];
			}else {
				mediumLast+=numbers[i];
			}
		}
		if (mediumFirst>mediumLast) {
			System.out.println("giá trị trung bình của 5 số đầu lớn hơn");
		}else if (mediumFirst==mediumLast) {
			System.out.println("giá trị trung bình của 5 số đầu và 5 số sau bằng nhau");
		}else {
			System.out.println("giá trị trung bình của 5 số sau lớn hơn");
		}
	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int[] results = new int[numbers.length];
		boolean[] flags = new boolean[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (flags[i] == false) {
				for (int j = i + 1; j < numbers.length; j++) {
					if (numbers[i] == numbers[j]) {
						flags[i] = true;
						flags[j] = true;
					}
				}
			}
		}
		int index=0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i]==false) {
				results[index++]=numbers[i];
			}
		}
		return Arrays.copyOfRange(results, 0, index);
	}
}
