package BTDATE01;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Bai4 {
	public static void main(String[] args) {
		Random rd = new Random();
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rd.nextInt(100) + 1;
			System.out.print(numbers[i] + "  ");
		}

		System.out.println();
		
		System.out.print("Bubble Sort:  ");
		shellSort(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.print(number+"  "));
		/*
		Student[] students = mock();
		objectSort(students);
		Arrays.stream(students).forEach(student -> System.out.println(student));*/
	}

	private static void swap(int[] numbers, int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;
	}

	private static void bubbleSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = numbers.length - 1; j > i; j--) {
				if (numbers[j] < numbers[j - 1]) {
					swap(numbers, j, j - 1);
				}
			}
		}
	}
	
	private static void selectionSort(int[] numbers) {
		for(int i=0; i<numbers.length-1; i++) {
			int minArr = i;
			for(int j=i+1; j<numbers.length; j++) {
				if(numbers[minArr]>numbers[j]) {
					minArr = j;
				}
			}
			if(i!=minArr)
				swap(numbers, minArr, i);
		}
	}
	
	private static void insertionSort(int[] numbers) {
		for(int i=1; i<numbers.length; i++) {
			int x = numbers[i];
			int y = i;
			while( y > 0 && numbers[ y - 1 ] > x ) {
				numbers[y]=numbers[y-1];
				y--;
			}
			numbers[y]=x;
		}
	}
	
	private static void objectSort(Student[] students) {
		Comparator<Student> comparator = comparing(Student::getId).thenComparing(Student::getAge);
		Arrays.sort(students, comparator);
	}
	
	private static void shellSort(int[] numbers) {
		int i;
		int j;
		int temp;
		int gap = 1;
		int len = numbers.length;
		while (gap < len/3) {
			gap = gap * 3 + 1;
		}
		for (; gap > 0; gap /= 3) {
			for (i = gap; i < len; i++) {
				temp = numbers[i];
				for (j = i - gap; j >= 0 && numbers[j] > temp; j -= gap) {
					numbers[j + gap] = numbers[j];
				}
				numbers[j + gap] = temp;
			}
		}
	}
	
	private static Student[] mock() {
		return new Student[] { 
				new Student("sv01", "Le Van Na", 24), 
				new Student("sv31", "Hoang Nam", 28),
				new Student("sv01", "Nguyen Teo", 21), 
				new Student("sv28", "Dang Van Ngoc", 18),
				new Student("sv05", "Van Van", 20), 
				new Student("sv01", "Phan Thanh", 16),
				new Student("sv03", "Truong Thi Ni", 22), 
				new Student("sv11", "Le Lieu", 24),
				new Student("sv25", "Dang Dung", 23), 
				new Student("sv07", "Nguyen Van An", 19) };
	}

}
