package exercise;

public class Ex01 {
	public static void main(String[] args) {
		String inputString = "we are learning the bad pro language ";
		System.out.println(countString(inputString));
	}
	
	private static int countString(String s) {
		String[] words = s.split("[\\s]+");
		return words.length;
	}
}
