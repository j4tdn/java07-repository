package java07.TEST09_PhanThanhTrung;

public class Bt1 {
	public static void main(String[] args) {
		String str = "phải chi ngày đó mình đừng yêu nhau";
		int count = 0;
		String[] strarr = str.split("[\\s]+");
		for (String str1 : strarr) {
			count += 1;

		}
		System.out.println("Số các kí tự: " + count);
	}
}
