package date_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) throws InterruptedException {
		List<Ex03_student> student = new ArrayList<>();
		student = createStudents();
		show(student);
		student =choseStudents(student);
		show(student);
		randomStudent(student);
	}

	private static List<Ex03_student> createStudents() {
		List<Ex03_student> studets = new ArrayList<Ex03_student>();
		Ex03_student student1 = new Ex03_student(1, "le nhat phi", 9.1);
		Ex03_student student2 = new Ex03_student(2, "le  phi", 8.2);
		Ex03_student student3 = new Ex03_student(3, "le nhat", 7.3);
		Ex03_student student4 = new Ex03_student(4, "nhat phi", 1.3);
		Ex03_student student5 = new Ex03_student(5, "nhat le ", 5.3);
		List<Ex03_student> students = Arrays.asList(student1, student2, student3, student4, student5);
		return students;
	}

	private static void show(List<Ex03_student> students) {
		for (Ex03_student student : students) {
			System.out.println(student + " ");
		}
	}

	private static List<Ex03_student> choseStudents(List<Ex03_student> students) {
		System.out.println("======Mix students=======");
		List<Ex03_student> tmp = new ArrayList<Ex03_student>();
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

	private static void randomStudent(List<Ex03_student> students) throws InterruptedException {
		Random rd = new Random();
		Random rand = new Random();
		while (true) {
			int index = rand.nextInt(students.size());
			System.out.println(students.get(index));
			Thread.sleep(5000);
		}
	}

}
