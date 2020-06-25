package bt.b1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai2 {
	private static Scanner ip = new Scanner(System.in);
	private static String IDDELETE = "HD-007";
	private static final int MONTH = 8;
	private static final int YEAR = 2017;

	public static void main(String[] args) {
		List<Bill> bills = new ArrayList<>();
		bills = BillUtils.getBills(bills);
		bills = BillUtils.setTotals(bills);
		BillUtils.show(bills);

		System.out.println(
				"==============================================================================================");
		int[] result = BillUtils.countingByType(bills);
		System.out.print("Tong so hoa don theo gio: " + result[0] + "\n");
		System.out.print("Tong so hoa don theo ngay: " + result[1] + "\n");

		System.out.println(
				"==============================================================================================");
		System.out.println("Them 1 hoa don:");
		BillUtils.add(bills);
		BillUtils.show(bills);

		System.out.println(
				"==============================================================================================");
		System.out.println("Xoa hoa don co ma HD-007");
		bills = BillUtils.delete(bills, IDDELETE);
		BillUtils.show(bills);

		System.out.println(
				"==============================================================================================");
		System.out.print("Trung binh thanh tien cua hoa don trong 09/2017: "
				+ BillUtils.averageAmountOfMonth(bills, MONTH, YEAR));
	}
}
