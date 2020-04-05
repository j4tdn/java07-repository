package java07.TEST09_PhanThanhTrung;

public class BT3Request {
	public static void main(String[] args) {

		String[] stds = { "102-Nam-C", "104-Hoàng-D", "109-Lan-A", "102-Bảo-F", "105-Nguyên-B", "107-Vũ-F",
				"103-Bảo-F", "202-Đạt-C", "107-Vũ-C", "193-Bảo-B", "199-Tài-A" };
		for (String std : stds) {
			String[] arr = std.split(",\\s", 3);
		
			System.out.println(std);
		}
		

	}

}
