package bt1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bt03 {
	public static List<Student> students = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("=============MENU=============");
			System.out.println("1.Nhap danh sach sinh vien");
			System.out.println("2.Xem danh sach sinh vien");
			System.out.println("3.Sap xep va hien thi danh sach sinh vien tang dan theo diem trung binh");
			System.out.println("4.Sap xep va hien thi danh sach sinh vien theo bang chu cai alphabet");
			System.out.println("5.Them sinh vien vao danh sach");
			System.out.println("6.Tim kiem sinh vien theo ma");
			System.out.println("7.Xoa 1 sinh vien bi duoi hoc khoi danh sach");
			System.out.println("8.Exit");
			System.out.println(">Nhap c can thuc hien :");
			int in = Integer.parseInt(sc.nextLine());
			switch (in) {
			case 1:
				StudentUtils.imp(students);

				break;

			case 2:
				StudentUtils.out(students);

				break;
			case 3:
				StudentUtils.sortByAverage(students);

				break;
			case 4:
				StudentUtils.sortByName(students);

				break;
			case 5:
				StudentUtils.add(students);

				break;
			case 6:
				StudentUtils.search(students);

				break;
			case 7:
				StudentUtils.remove(students);

				break;
			case 8:
				System.exit(0);

				break;
			default:
				break;
			}
		} while (true);

	}

}
