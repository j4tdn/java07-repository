package date02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.StoreCD;

public class Ex02 {
	public static void main(String[] args) {
		List<StoreCD> storeCDs = new ArrayList<>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(" _____________________________________");
			System.out.println("|QUẢN LÝ CỦA HÀNG CD                  |");
			System.out.println("|1. Tạo danh sách.                    |");
			System.out.println("|2. In danh sách CD.                  |");
			System.out.println("|3. Thêm một CD.                      |");
			System.out.println("|4. Tính số lượng đĩa CD.             |");
			System.out.println("|5. Tính tổng tiền của tất cả đĩa CD. |");
			System.out.println("|6. Sắp xếp tăng dần theo giá thành.  |");
			System.out.println("|7. Sắp xếp tăng dần theo loại CD.    |");
			System.out.println("|0. Exit.                             |");
			System.out.println("|_____________________________________|");
			System.out.print("-> Nhập lựa chọn: ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				StoreCDUtil.createData(storeCDs);
				System.out.println("Đã tạo dữ liệu thành công!");
				break;
			case 2:
				System.out.println("IN DANH SÁCH CD TRONG STORE:");
				StoreCDUtil.print(storeCDs);
				break;
			case 3:
				StoreCDUtil.addCD(storeCDs);
				break;
			case 4:
				System.out.println("SỐ LƯỢNG ĐĨA CD: " + storeCDs.size());
				break;
			case 5:
				System.out.println("TỔNG TIỀN CỦA ALL CD: " + StoreCDUtil.totalMon(storeCDs));
				break;
			case 6:
				System.out.println("SẮP XẾP TĂNG DẦN THEO GIÁ THÀNH:");
				StoreCDUtil.sortByPrice(storeCDs);
				break;
			case 7:
				System.out.println("SẮP XẾP TĂNG DẦN THEO LOẠI CD:");
				StoreCDUtil.sortBySpecies(storeCDs);
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Nhập 1 số từ 0 -> 7 !");
				break;
			}
		} while (true);
	}
}