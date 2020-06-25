package date01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.Bill;
import beans.DaysBill;
import beans.HoursBill;

public class Ex02 {
	public static void main(String[] args) {
		List<HoursBill> hourlyBill = new ArrayList<>();
		List<DaysBill> dayBill = new ArrayList<>();

		System.out.println("<1> Nhập danh sách các hóa đơn cho thuê phòng:");
		hourlyBill.add((HoursBill) input(new HoursBill()));
		dayBill.add((DaysBill) input(new DaysBill()));
		System.out.println("==============================================");
		System.out.println("<2> Danh sách các hóa đơn cho thuê phòng:");
		output(hourlyBill);
		output(dayBill);
		System.out.println("==============================================");
		System.out.println("<3> Tổng số lượng cho từng loại phòng thuê:");
		System.out.println("  > Phòng thuê theo GIỜ:  " + hourlyBill.size());
		System.out.println("  > Phòng thuê thoe NGÀY: " + dayBill.size());
		System.out.println("==============================================");
		System.out.println("<4> Thêm một hóa đơn cho thuê phòng:");
		System.out.println("  > 1. Hóa đơn theo giờ.");
		System.out.println("  > 2. Hóa đơn theo ngày.");
		do {
			System.out.print("  > Nhập lựa chọn: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				hourlyBill.add((HoursBill) input(new HoursBill()));
				break;
			case 2:
				dayBill.add((DaysBill) input(new DaysBill()));
				break;
			default:
				System.out.println("Vui lòng chỉ nhập 1 hoặc 2 !!!");
			}
			if (select == 1 || select == 2) {
				break;
			}
		} while (true);
		System.out.println("==============================================");
		System.out.println(" >> Danh sách các hóa đơn cho thuê phòng <<");
		output(hourlyBill);
		output(dayBill);
		System.out.println("==============================================");
		System.out.println("<5> Xóa một hóa đơn thuê phòng có mã hóa đơn là HD-007");
		hourlyBill.removeIf(b -> "HD-007".equals(b.getCodeBill()));
		dayBill.removeIf(b -> "HD-007".equals(b.getCodeBill()));
		output(hourlyBill);
		output(dayBill);
		System.out.println("==============================================");
		List<Bill> bills = new ArrayList<>(hourlyBill);
		bills.addAll(dayBill);
		String month = "09/2017";
		float averageToMon = averageToMoney(bills, month);
		System.out.println("TB thành tiền của hóa đơn thuê phòng trong tháng 09/2017: " + averageToMon);
	}

	private static Bill input(Bill bill) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String status = "";
		if (bill instanceof HoursBill) {
			status = "GIỜ";
		} else {
			status = "NGÀY";
		}
		System.out.println("NHẬP HÓA ĐƠN THEO " + status + ":");
		System.out.print("- Mã hóa đơn              : ");
		String codeBill = sc.nextLine();
		bill.setCodeBill(codeBill);
		System.out.print("- Ngày hóa đơn(dd/mm/yyyy): ");
		String date = sc.nextLine();
		bill.setDate(date);
		System.out.print("- Tên khách hàng          : ");
		String fullName = sc.nextLine();
		bill.setFullName(fullName);
		System.out.print("- Mã phòng                : ");
		String roomCode = sc.nextLine();
		bill.setRoomCode(roomCode);
		System.out.print("- Đơn giá                 : ");
		int unitPrice = Integer.parseInt(sc.nextLine());
		bill.setUnitPrice(unitPrice);
		if ("GIỜ".equals(status)) {
			int hour = 0;
			do {
				System.out.print("- Số giờ                  : ");
				hour = Integer.parseInt(sc.nextLine());
				if (hour > 30) {
					System.out.println("Trường hợp số giờ là > 30 tiếng thì không dùng loại hóa đơn theo giờ.");
				} else {
					break;
				}
			} while (true);
			((HoursBill) bill).setHour(hour);
			bill.pay();
		}
		if ("NGÀY".equals(status)) {
			System.out.print("- Số ngày                 : ");
			int day = Integer.parseInt(sc.nextLine());
			((DaysBill) bill).setDay(day);
			bill.pay();
		}
		return bill;
	}

	private static <E> void output(List<E> e) {
		if (e instanceof HoursBill) {
			System.out.println("HÓA ĐƠN THEO GIỜ:");
			e.forEach(b -> {
				System.out.println("------------------");
				System.out.println(b);
				System.out.println("------------------");
			});
		} else {
			System.out.println("HÓA ĐƠN THEO NGÀY:");
			e.forEach(b -> {
				System.out.println("------------------");
				System.out.println(b);
				System.out.println("------------------");
			});
		}
	}

	private static float averageToMoney(List<Bill> bill, String month) {
		float averageToMon = 0.0f;
		for (Bill b : bill) {
			String tmp = b.getDate().substring(3);
			if (month.equals(tmp)) {
				averageToMon += b.getPrice();
			}
		}
		return averageToMon;
	}
}