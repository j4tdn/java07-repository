package date1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import beans.Student;

public class Ex04 {
	
	private static Scanner sc = new Scanner(System.in);
	private static Random rd = new Random();
	
	public static void main(String[] args) throws InterruptedException {
		menu();
	}

	private static void menu() throws InterruptedException {
		int choose = 0;
		List<Student> students = mock();
		do {
			System.out.println("==============MENU==============");
			System.out.println("1.Show data");
			System.out.println("2.Suffer data");
			System.out.println("3.Sort by average");
			System.out.println("Enter...");
			choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				showData(students);
				break;
			case 2:
				Collections.shuffle(students);
				break;
			case 3:
				Student randomStudent = randomStudent(students);
				System.out.println(randomStudent);
				break;

			default:
				break;
			}
		} while (choose != 0);
	}

	private static Student randomStudent(List<Student> students) throws InterruptedException {
		int index = rd.nextInt(students.size());
		Thread.sleep(1000);
		return students.get(index);
	}

	private static void showData(List<Student> students) {
		students.forEach(System.out::println);
	}

	private static List<Student> mock() {
		List<Student> students = new ArrayList<>();
		Student s1 = new Student("sv01", "Phan Thanh Binh", 8.2f);
		Student s2 = new Student("sv02", "Phan Dinh Binh", 9.0f);
		Student s3 = new Student("sv03", "Nguyen Dinh Hoang", 8.1f);
		Student s4 = new Student("sv04", "Nguyen Que An", 7.5f);
		Student s5 = new Student("sv05", "Vo Song Giang", 6.5f);
		Student s6 = new Student("sv06", "Phan Thanh Duong", 7.2f);
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		return students;
	}
	
	
}
