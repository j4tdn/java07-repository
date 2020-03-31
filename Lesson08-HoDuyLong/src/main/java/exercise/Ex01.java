package exercise;

public class Ex01 {
	public static void main(String[] args) {
		String inputString = "Xin chào";

		printCharacter(inputString);

		System.out.println("--------------------");
		printWord(inputString);

		System.out.println("--------------------");
		reverseCharacter(inputString);

		System.out.println("--------------------");
		reverseWord(inputString);
	}

	private static void printCharacter(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}

	private static void printWord(String s) {
		String[] array = s.split("[\\s]+");
		for (String string : array) {
			System.out.println(string);
		}
	}

	private static void reverseCharacter(String s) {
		String[] array = s.split("[\\s]+");
		StringBuilder sb = new StringBuilder();
		for (int i = array.length - 1; i >= 0; i--) {
			sb.append(array[i] + " ");
		}
		String result = sb.toString().trim();
		System.out.println(result);
	}

	private static void reverseWord(String s) {
		StringBuilder sb1 = new StringBuilder(s);
		System.out.println(sb1.reverse().toString());
	}
}
