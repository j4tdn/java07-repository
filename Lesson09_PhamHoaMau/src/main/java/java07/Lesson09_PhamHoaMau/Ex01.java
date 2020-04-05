package java07.Lesson09_PhamHoaMau;

public class Ex01 {
	static int count = 0;

	public static void main(String[] args) {
		String input = " adasd  sad asd   asd  hello   world    ";
		countTheNumberOfWords(input);
	}

	private static void countTheNumberOfWords(String input) {
		input = input.replaceAll("[\\s]+", " ").trim();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				count += 1;
			}
		}
		System.out.println((count + 1) + " words");
	}
}
