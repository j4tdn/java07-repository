package declaration_allcation;

import beans.Student;

public class Ex01 {

	public static void main(String[] args) {
		//primitive 
		//object
		//+String, Integer, Double, Float
		//+Manual object: Student, Employee
		
		//first way
		int[] firstNumbers = new int[3];
		firstNumbers[1] = 99;
		System.out.println("1st: " + firstNumbers[0] + "-" + firstNumbers[1] + "-" + firstNumbers[2]);
		
		//second way
		int[] secondNumbers = {11, 22, 0};
		System.out.println("2nd: " + secondNumbers[0] + "-" + secondNumbers[1] + "-" + secondNumbers[2]);
		//for-index
		System.out.println("===========");
		for (int i = 0; i < secondNumbers.length; i++) {
			System.out.println(i + ": " + secondNumbers[i]);
		}
		
		//for each
		for (int number: secondNumbers) {
			System.out.println("number: " + number);
		}
		
		String[] firstStrings = new String[4];
		System.out.println(firstStrings[0] + "-" + firstStrings[1]);
		
		String[] secondStrings = {"A", "B", "C"};
		System.out.println(secondStrings[0] + "-" + secondStrings[1]);
		
		Student[] students = new Student[2];
		System.out.println(students[0] + "-" + students[1]);
		students[0] = new Student();
		students[0].setFullname("Le Na");
		students[0].setId("01");
		System.out.println(students[0] + "-" + students[1]);
		
	}

}
