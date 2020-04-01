package java07.Lesson08_PhamHoaMau;

public class Ex01 {
	public static void main(String[] args) {
		String s = "Hello World";
		printChar(s);
		printWord(s);
		reverseWithWord(s);
		reverseWithChar(s);
	}

	private static void printChar(String s) {
		System.out.println("Print each char on each line");
		char[] charArray = s.replaceAll("[\\s]+", "").toCharArray();
		for (char c : charArray) {
			System.out.println(c);
		}
	}

	private static void printWord(String s) {
		System.out.println("Print each word on each line");
		String[] stringArray = s.split("[\\s]+");
		for (String word : stringArray) {
			System.out.println(word);
		}
	}

	private static void reverseWithWord(String s) {
		System.out.println("Reverse with word");
		String[] stringArray = s.split("[\\s]+");
		String string = "";
		for (int i = stringArray.length - 1; i >= 0; i--) {
			string += stringArray[i] + " ";
		}
		System.out.println(string);
	}

	private static void reverseWithChar(String s) {
		System.out.println("Reverse with char");
		char[] charArray = s.toCharArray();
		String string = "";
		for (int i = charArray.length - 1; i >= 0; i--) {
			string += charArray[i];
		}
		System.out.println(string);
	}
}
