package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import bean.Student;

public class Ex1_4 {
	public static void main(String[] args) throws InterruptedException {
		List<Student> students = new ArrayList<Student>();
		students = createStudents();
		showStudents(students);
		students = mixStudents(students);
		showStudents(students);
		randomStudent(students);

	}

	private static void randomStudent(List<Student> students) throws InterruptedException {
		System.out.println("======Random students=======");
		Random rand = new Random();
		while (true) {
			int index = rand.nextInt(students.size());
			System.out.println(students.get(index));
			Thread.sleep(5000);
		}
	}

	private static List<Student> mixStudents(List<Student> students) {
		System.out.println("======Mix students=======");
		List<Student> tmp = new ArrayList<Student>();
		Random rand = new Random();
		int index = rand.nextInt(students.size());
		for (int i = 0; i < students.size(); i++) {
			while (tmp.contains(students.get(index))) {
				index = rand.nextInt(students.size());
			}
			tmp.add(students.get(index));
		}
		return tmp;
	}

	private static void showStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student + " ");
		}
	}

	private static List<Student> createStudents() {
		System.out.println("====Create Students====");
		List<Student> students = new ArrayList<Student>();
		Student student1 = new Student(1, "Nguyen A", 8.5);
		Student student2 = new Student(2, "Nguyen B", 8.1);
		Student student3 = new Student(3, "Nguyen C", 8.9);
		Student student4 = new Student(4, "Nguyen D", 8.0);
		Student student5 = new Student(5, "Nguyen E", 1.7);
		students = Arrays.asList(student1, student2, student3, student4, student5);
		return students;
	}

}
