package bt;

public class Ex01 {
	public static void main(String[] args) {
		String str = "we are learning the bad pro language";

		String[] words = str.split("[\\s]+");

		int count = words.length;

		System.out.println(count + " words.");
	}
}