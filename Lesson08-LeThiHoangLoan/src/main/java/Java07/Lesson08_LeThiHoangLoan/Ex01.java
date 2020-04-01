package Java07.Lesson08_LeThiHoangLoan;

public class Ex01 {
	public static void main(String[] args) {
		String s = "Cùng nhau xây dựng cộng đồng Xanh";

		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
		System.out.println("==================");
		String[] sArray = s.split("[\\s]");
		for (String s1 : sArray) {
			System.out.println(s1);
		}
		
		System.out.println("==================");
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
		
		System.out.println("\n==================");
		for (int i = sArray.length - 1; i >= 0; i--) {
			System.out.print("\n" + sArray[i]);
		}

	}
}
