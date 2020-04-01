package java07.Lesson08_PhamHoaMau;

public class Ex02 {
	public static void main(String[] args) {
		String fullname = "pham  hoa   mau";
		fulnameOnlyContainNomalChar(fullname);
		uppercaseFirstCharOfWord(fullname);
		charSeparateSpace(fullname);

	}

	private static void fulnameOnlyContainNomalChar(String fullname) {
		String s = fullname.replaceAll("\\s+", "");
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < 'A' || s.charAt(i) > 'z') {
				System.out.println("Warning: fulname Only Contain Nomal Char!!!");
				break;
			}
		}
	}

	private static void uppercaseFirstCharOfWord(String fullname) {
		String[] stringArray = fullname.split("\\s+");
		String result = "";
		for (String word : stringArray) {
			word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
			result += word + " ";
		}
		System.out.println("Fullname after uppercase first char of word: " + result);
	}

	private static void charSeparateSpace(String fullname) {
		char[] charArray = fullname.replaceAll("\\s+", "").toCharArray();
		String result = "";
		for (char c : charArray) {
			result += c + " ";
		}
		System.out.println("Each char separate each space: " + result);
	}
}
