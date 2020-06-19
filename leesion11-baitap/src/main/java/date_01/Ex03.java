package date_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		List<Ex03_student> students = new ArrayList<>();
		int number = 1;
		switch (number) {
		case 1:
			System.out.println("Xem thông tin sinh viên");
			students = createStudents();
			show(students);
			break;
		case 2:
			System.out.println("Sắp xếp thông tin sinh viên theo điểm");
			students = createStudents();
			sortStudentPoint(students);
			show(students);
			break;
		case 3:
			System.out.println("Sắp xếp thông tin sinh viên theo tên");
			students = createStudents();
			sortName(students);
			show(students);
			break;
		case 4:
			System.out.println("Tìm  sinh viên");
			students = createStudents();
			searchID(students, 2);
			break;
		case 5:
//			System.out.println("Xoá Sinh viên");
//			students = createStudents();
//			deleteStudent(students);
//			show(students);
			break;
		}

	}

	private static void show(List<Ex03_student> students) {
		for (Ex03_student student : students) {
			System.out.println(student + " ");
		}
	}

	private static void sortStudentPoint(List<Ex03_student> students) {
		Collections.sort(students, (o1, o2) -> o1.getPoint().compareTo(o2.getPoint()));
	}

	private static void sortName(List<Ex03_student> students) {
		Collections.sort(students, (o1, o2) -> o1.getNameStudent().compareTo(o2.getNameStudent()));
	}

	private static void searchID(List<Ex03_student> students, Integer id) {
		for (Ex03_student student : students) {
			if (id.equals(student.getIdStudent())) {
				System.out.println(student);
			}
		}
	}

	private static List<Ex03_student> deleteStudent(List<Ex03_student> students) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getIdStudent().equals(students.get(i).getIdStudent())) {
				students.remove(i);
			}
		}
		return students;
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

}
