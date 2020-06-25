package date02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.English;

public class Ex04 {
	public static void main(String[] args) {
		List<English> englishs = new ArrayList<>();
		do {
			System.out.println(" _______________________________");
			System.out.println("|        TỪ ĐIỂN ANH-VIỆT       |");
			System.out.println("|1. THÊM TỪ ĐIỂM MỚI.           |");
			System.out.println("|2. IN DANH SÁCH TỪ CÓ TRONG TĐ.|");
			System.out.println("|3. TÌM KIẾM MỘT TỪ TRONG TĐ.   |");
			System.out.println("|0. EXIT.                       |");
			System.out.println("|_______________________________|");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.print("> Nhập lựa chọn: ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				System.out.println("Thêm từ vào TĐ:");
				Dictionary.addWord(englishs);
				break;
			case 2:
				System.out.println("Danh sách các từ có trong TĐ:");
				Dictionary.print(englishs);
				break;
			case 3:
				System.out.println("Tìm kiếm:");
				Dictionary.searchWord(englishs);
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Nhập 1 số từ 0 -> 3 !");
			}
		} while (true);
	}
}