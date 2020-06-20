package bt.b1;

import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Scanner;

public class StudentUtils {
	private static Scanner ip = new Scanner(System.in);

	private StudentUtils() {

	}

	public static void menu(List<Student> students) {
		int n;
		do {
			System.out.println("1.Nhap danh sach sinh vien");
			System.out.println("2.Xem danh sach sinh vien");
			System.out.println("3.Sap xep theo diem trung binh");
			System.out.println("4.Sap xep theo bang chu cai alphabet");
			System.out.println("5.Them sinh vien");
			System.out.println("6.Tim kiem sinh vien");
			System.out.println("7.Xoa sinh vien");
			System.out.println("8.Huy");
			n = Integer.parseInt(ip.nextLine());
			switch (n) {
			case 1:
				students = getStudent(students);// similar to adding students
				break;
			case 2:
				students.sort(comparing(Student::getId));
				show(students);
				break;
			case 3:
				sortByAverage(students);
				break;
			case 4:
				sortByName(students);
				break;
			case 5:
				System.out.print("Nhap so sinh vien can them: ");
				int m = Integer.parseInt(ip.nextLine());
				addStudents(students, m);
				break;
			case 6:
				System.out.print("Nhap MSSV: ");
				String idSearch = ip.nextLine();
				Student result = search(idSearch, students);
				System.out.println((result != null) ? result : "Khong co trong danh sach!");
				break;
			case 7:
				System.out.print("Nhap MSSV: ");
				String idDelete = ip.nextLine();
				delete(idDelete, students);
			}
		} while (n != 8);
	}

	public static List<Student> getStudent(List<Student> students) {
		Student std1 = new Student("1", "Van Nam", 7.8);
		Student std2 = new Student("2", "Le Na", 8.6);
		Student std3 = new Student("3", "Ngoc Thanh", 8.9);
		Student std4 = new Student("4", "Phan Ka", 6.5);
		Student std5 = new Student("5", "Hoang Teo", 7.7);
		students.add(std1);
		students.add(std2);
		students.add(std3);
		students.add(std4);
		students.add(std5);
		return students;
	}

	public static void show(List<Student> students) {
		System.out.println("========================================");
		students.forEach(student -> System.out.println(student));
		System.out.println("========================================");
	}

	private static void sortByAverage(List<Student> students) {
		students.sort(comparing(Student::getAverage));
		show(students);
	}

	private static void sortByName(List<Student> students) {
		students.sort(comparing(Student::getName));
		show(students);
	}

	private static Student inputStudent(List<Student> students) {
		System.out.print("Nhap diem trung binh: ");
		double average = Double.parseDouble(ip.nextLine());
		System.out.print("Nhap MSSV: ");
		String id = ip.nextLine();
		System.out.print("Nhap ho ten: ");
		String name = ip.nextLine();

		Student std = new Student(id, name, average);

		for (Student student : students) {
			if (student.getId().equals(id)) {
				return null;
			}
		}
		return std;
	}

	private static void addStudents(List<Student> students, int m) {
		for (int i = 0; i < m; i++) {
			Student inputStudent = inputStudent(students);
			if (inputStudent != null) {
				students.add(inputStudent);
			} else {
				continue;
			}
		}
	}

	private static Student search(String id, List<Student> students) {
		for (Student student : students) {
			if (student.getId().equals(id))
				return student;
		}
		return null;
	}

	private static void delete(String id, List<Student> students) {
		Student result = search(id, students);
		if (result != null) {
			students.remove(result);
		} else {
			System.out.println("Khong co trong danh sach!");
		}
	}
}
