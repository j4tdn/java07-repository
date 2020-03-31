package exercise;

public class Ex01 {
	public static void main(String[] args) {
		String str = "Phan    binh itbk";
		getChars(str);
		System.out.println();
		getWords(str);
		System.out.println();
		reverseChar(str);
		System.out.println();
		reverseWord(str);
	}

	private static void getChars(String str) {
		for (char c : str.toCharArray()) {
			System.out.print(c + "-");
		}
	}

	private static void getWords(String str) {
		String[] words = str.split("[\\s]+");
		for (String word : words) {
			System.out.print(word + "-");
		}
	}

	private static void reverseChar(String str) {
		for (int i = str.length() - 1; i > 0; i--) {
			System.out.print(str.charAt(i) + "-");
		}
	}

	private static void reverseWord(String str) {
		String[] words = str.split("[\\s]+");
		for (int i = words.length - 1; i > 0; i--) {
			System.out.print(words[i] + "-");
		}
	}
}
