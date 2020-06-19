package date01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Scanner;

import beans.Student;

public class Ex03 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("===========MENU=============");
		System.out.println("1. Input student list");
		System.out.println("2. Display student list");
		System.out.println("3. Sort and display student list in ascending of GPA");
		System.out.println("4. Sort and display student list in alphabet");
		System.out.println("5. Add students into the list");
		System.out.println("6. Search students by Id");
		System.out.println("7. Delete a student");
		System.out.println("0. Quit");

		int n = 0;

		List<Student> students = new ArrayList<>();

		do {
			System.out.print("=> Your choice: ");
			n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				inputList(students);
				break;
			case 2:
				displayList(students);
				break;
			case 3:
				sortByGPA(students);
				break;
			case 4:
				sortByAlphabet(students);
				break;
			case 5:
				addStudents(students);
				break;
			case 6:
				Student student = findStudent(students);
				if (student != null) {
					System.out.println(student);
				} else {
					System.out.println("Cannot find!");
				}
				break;
			case 7:
				remove(students);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid input!");
			}
		} while (n != 0);
	}

	private static List<Student> inputList(List<Student> students) {
		Student s1 = new Student("SV-01", "Ho Duy Long", 3.22f);
		Student s2 = new Student("SV-02", "Ho Quang Phuoc", 3.9f);
		Student s3 = new Student("SV-03", "Pham Manh Dung", 3.68f);

		students.add(s1);
		students.add(s2);
		students.add(s3);
		return students;
	}

	private static void displayList(List<Student> students) {
		students.forEach(System.out::println);
	}

	private static void sortByGPA(List<Student> students) {
		Comparator<Student> comparator = comparing(Student::getGpa);
		Collections.sort(students, comparator);
		displayList(students);
	}

	private static void sortByAlphabet(List<Student> students) {
		Comparator<Student> comparator = comparing(Student::getFullname);
		Collections.sort(students, comparator);
		displayList(students);
	}

	private static void addStudents(List<Student> students) {
		System.out.print("The number of students you want to add: ");
		int number = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < number; i++) {
			Student student = new Student();
			System.out.print("Input id: ");
			student.setId(sc.nextLine());
			System.out.print("Input fullname: ");
			student.setFullname(sc.nextLine());
			System.out.print("Input gpa: ");
			student.setGpa(Float.parseFloat(sc.nextLine()));
			students.add(student);
		}
	}

	private static Student findStudent(List<Student> students) {
		System.out.println("Input id student you want to find: ");
		String id = sc.nextLine();

		for (Student student : students) {
			if (id.equals(student.getId())) {
				return student;
			}
		}
		return null;
	}

	private static void remove(List<Student> students) {
		System.out.print("Input id student you want to remove: ");
		String id = sc.nextLine();

		students.removeIf(student -> id.equals(student.getId()));
	}
}
