package Java07.Lesson08_LeThiHoangLoan;

public class Ex06 {
	public static void main(String[] args) {
		long temp = 1;
		int k = 219;
		String str = "";
		do {
			temp++;
			str += String.valueOf(temp);
		} while (str.length() < k);

		System.out.println(str.charAt(k - 1));
	}
}
