package date01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex03 {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int tmp;
		int key = 0;
		List<Student> students = null;
		do {
			System.out.println("1.Nhập danh sách sinh viên\r\n");
			System.out.println("2.Xem danh sách sinh viên\r\n");
			System.out.println("3.Sắp xếp và hiển thị danh sách sinh viên theo chiều tăng dần của điểm trung bình\r\n");
			System.out.println("4.Sắp xếp và hiển thị danh sách sinh viên theo bằng chữ cái alphabet\r\n");
			System.out.println("5.Thêm sinh viên vào danh sách. Có thể [1||n] sinh viên\r\n");
			System.out.println("6.Tìm kiếm sinh viên theo mã.\r\n");
			System.out.println("7.Xóa một sinh viên bị đuổi học khỏi danh sách");
			System.out.println("\nNhap cong viec ");

			key = ip.nextInt();

			switch (key) {
			case 1:
				students = creat();
				break;
			case 2:
				show(students);
				break;
			case 3:
				AscMediumScore(students);
				show(students);
				break;
			case 4:
				sortByName(students);
				show(students);
				break;
			case 5:
				add(students, 2);
				show(students);
				break;
			case 6:
				find(students);
				break;
			case 7:
				remove(students);
				show(students);
				break;
			}
			System.out.println("\nContinue 1(yes)/0(no):");
			tmp = ip.nextInt();
		} while (tmp == 1);
	}

	public static List<Student> creat() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("SV03", "Le An", 9.0));
		students.add(new Student("SV04", "Tran Binh", 7.4));
		students.add(new Student("SV05", "Ly Cuong", 8.5));
		students.add(new Student("SV02", "Nguyen Dung", 7.9));
		students.add(new Student("SV06", "Phan En", 6.7));
		return students;

	}

	public static void show(List<Student> students) {
		students.forEach(System.out::println);
	}

	public static List<Student> AscMediumScore(List<Student> students) {
		students.sort((s1, s2) -> s1.getMediumScore().compareTo(s2.getMediumScore()));
		return students;
	}

	public static List<Student> sortByName(List<Student> students) {
		students.sort((s1, s2) -> s1.getFullName().compareTo(s2.getFullName()));
		return students;
	}

	public static List<Student> add(List<Student> students, int n) {
		int i = 1;
		while (i <=n) {
			Student s = new Student();
			ip.nextLine();
			System.out.println("Sinh vien " + i + "\nNhap Id");
			s.setId(ip.nextLine());
			System.out.println("Nhap Ten");
			s.setFullName(ip.nextLine());
			System.out.println("Nhap Diem");
			s.setMediumScore(ip.nextDouble());
			students.add(s);
			i++;
		}
		return students;
	}

	public static void find(List<Student> students) {
		System.out.println("Nhap Id");
		String id = ip.nextLine();
		for (Student s : students) {
			if (id.equals(s.getId())) {
				System.out.println(s);
			}
		}
	}

	public static void remove(List<Student> students) {
		System.out.println("Nhap Id");
		ip.nextLine();
		String id = ip.nextLine();
		if (!id.equals(students)) {
			students.removeIf(s -> s.getId().equals(id));
		} else {
			System.out.println("ko co sv nay");
		}
	}
}
