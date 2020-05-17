package declaration_allocation;

import beans.Student;

public class Ex01 {

	public static void main(String[] args) {
		// primitive
		// object
		// + String, Integer, Double
		// + Manual object: Student, Employee
		
		// first way
		int[] firstNumbers = new int[3];
		firstNumbers[1] = 99;
		System.out.println("1st: " + firstNumbers[0] + "-" + firstNumbers[1] + "-" + firstNumbers[2]);
		
		// second way
		int[] secondNumbers = {1, 99, 3};
		System.out.println("2st: " + secondNumbers[0] + "-" + secondNumbers[1] + "-" + secondNumbers[2]);
		
		System.out.println("====================");
		// for-index
		for (int i = 0; i < secondNumbers.length; i++) {
			System.out.println(i + ": " + secondNumbers[i] + "---");
		}
		
		// for each
		for (int number : secondNumbers) {
			System.out.println("for each: " + number);
		}
		
		String[] firstStrings = new String[4];
		firstStrings[0] = " HELLO ";
		firstStrings[0] = firstStrings[0].trim();
		System.out.println(firstStrings[0] + "-" + firstStrings[1] + "-" + firstStrings[2] + "-" + firstStrings[3]);
		
		String[] secondStrings = {"A", "B", "C"};
		System.out.println(secondStrings[0] + "-" + secondStrings[1] + "-" + secondStrings[2]);
		
		System.out.println("====================");
		Student[] students = new Student[2];
		students[0] = new Student();
		students[0].setFullname("Ho Duy Long");
		students[0].setId("102170033");
		System.out.println(students[0] + "-" + students[1]);
	}

}
