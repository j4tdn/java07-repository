package java07.Lesson08_PhamHoaMau;

public class Ex06 {

	public static void main(String[] args) {
		int k = 100;
		String string = "";
		for (int i = 1; i < k; i++) {
			string += Integer.toString(i);
		}
		System.out.println("The string: " + string + "...");
		System.out.println("The " + k +"th character in the string is: " + string.charAt(k));
	}

}
