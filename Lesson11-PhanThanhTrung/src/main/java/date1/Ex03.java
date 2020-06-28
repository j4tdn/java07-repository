package date1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import student.Students;

public class Ex03 {
	public static void main(String[] args) {
		List<Students> students = new ArrayList<>();
		do {

			Scanner sc = new Scanner(System.in);

			System.out.println("1.Nhập danh sách sinh viên");
			System.out.println("2.Xem danh sách sinh viên");
			System.out.println("3.Sắp xếp theo chiều tăng dần ĐTB");
			System.out.println("4.Sắp xếp theo họ và tên:");
			System.out.println("5.Thêm sinh viên");
			System.out.println("6.Tìm kiếm 1 sinh viên");
			System.out.println("7.Xóa 1 sinh viên");
			System.out.println("8.Exit");
			System.out.println("Nhập lựa chọn:");
			int key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1:
				creatListStudent(students);
				break;
			case 2:
				students.forEach(System.out::println);
				break;
			case 3:
				sortMediumScore(students);
				break;
			case 4:
				sortByName(students);
				break;
			case 5:
				creatListStudent(students);
				break;
			case 6:
				searchStudentById(students);
				break;
			case 7:
				removeStudents(students);
				break;
			case 8:
				System.exit(0);
			}

		} while (true);

	}

	private static void creatListStudent(List<Students> students) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng sinh viên: ");
		int n = Integer.parseInt(sc.nextLine());
		while (n > 0) {
			Students std = new Students();

			while (true) {
				System.out.println("Nhập mssv: ");
				String id = sc.nextLine();
				if (checkId(students, id)) {
					std.setId(id);
					break;
				}
			}
			System.out.println("Nhập họ và tên: ");
			String fullName = sc.nextLine();
			std.setFullName(fullName);
			System.out.println("Nhập điểm trung bình: ");
			float ms = Float.parseFloat(sc.nextLine());
			std.setMediumScore(ms);
			students.add(std);
			n--;
		}

	}

	private static boolean checkId(List<Students> students, String id) {

		for (Students std : students) {
			if (std.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}

	private static void sortMediumScore(List<Students> students) {

		List<Students> std = new ArrayList<>(students);// copy list
		std.sort(Comparator.comparing(Students::getMediumScore));
		std.forEach(System.out::println);
	}

	private static void sortByName(List<Students> students) {
		List<Students> std = new ArrayList<>(students);
		std.sort(Comparator.comparing(Students::getFullName));
		std.forEach(System.out::println);
	}

	private static void searchStudentById(List<Students> students) {
		int count = 0;
		System.out.println(" Nhập mssv cần tìm: ");
		Scanner sc = new Scanner(System.in);
		String std = sc.nextLine();
		for (Students stds : students) {
			if (stds.getId().equals(std)) {
				System.out.println(stds);
				count++;
				break;
			}

		}
		if (count == 0) {
			System.out.println("đéo có ai có mã như vậy m nhầm r! ");
		}
	}

	private static List<Students> removeStudents(List<Students> students) {
		System.out.println(" Nhập mssv cần xóa: ");
		Scanner sc = new Scanner(System.in);
		String std = sc.nextLine();
		students.removeIf(s -> s.getId().equals(std));
		return students;
	}
}
