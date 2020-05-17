package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import common.Sort;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 11, 9, 5, 6, 6, 7, 13 };
		Arrays.sort(numbers);
		String[] students = { "Nam", null, "Hoa", null, "Binh", "Phuong", null };
		//Arrays.sort(students);
		
//		int keyNumber = 6;
//		String keyString = "Hoa";//so sanh 2 chuoi Compareto
//		System.out.println("========================");
//		System.out.println("int: " + Arrays.binarySearch(numbers, keyNumber));
//		System.out.println("string: " + Arrays.binarySearch(students, keyString));
	
		Arrays.sort(students, (o1, o2) -> {
			if (o1 == null) {
				return -1;
			} 
			
			if (o2 == null) {
				return 1;
			}
			
			return o1.compareTo(o2);
		});
//		Arrays.stream(students).forEach(student -> {System.out.println(student);});
		System.out.println("========================");
		
		//sort(students, Sort.DESC);
		Arrays.stream(students).forEach(student -> {System.out.println(student);});
	}
	
	private static void sort(String[] students, Sort sort) {
		for (int out = 0; out < students.length; out++) {
			if (students[out] == null) {
				continue;
			} else {
				for (int in = students.length - 1; in > out; in--) {
					if (students[in] == null) {
						String temp = students[in];
						students[in] = students[out];
						students[out] = temp;
						break;
					}
					
					int comparision = students[out].compareTo(students[in]);
					if (comparision > 0) {
						String temp = students[in];
						students[in] = students[out];
						students[out] = temp;
					}
				}
			}
		}
		
		if (Sort.DESC.equals(sort)) {
			reserved(students);
		}
	}
	
	private static void reserved(String[] students) {
		for (int i = 0; i < students.length / 2; i++) {
			String temp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = temp;
		}
	}
}
