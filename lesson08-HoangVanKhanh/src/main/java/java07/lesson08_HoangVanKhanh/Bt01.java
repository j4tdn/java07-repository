package java07.lesson08_HoangVanKhanh;

public class Bt01 {
	public static void main(String[] args) {
		String s1 = "Xin chào java07";

		for (int i = 0; i < s1.length(); i++) {
			System.out.print(s1.charAt(i) + "\n");
		}
		String[] array = s1.split("[\\s]+");
		for (String s : array) {
			System.out.println(s);
		}
		String reverse = new StringBuffer(s1).reverse().toString();

		for (int i = 0; i < reverse.length(); i++) {
			System.out.print(reverse.charAt(i) + "\n");
		}
		String[] arrays = reverse.split("[\\s]+");
		for (String s : arrays) {
			System.out.println(s);
		}

	}
}
