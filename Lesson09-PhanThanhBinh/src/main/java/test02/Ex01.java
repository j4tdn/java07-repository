package test02;

public class Ex01 {
	public static void main(String[] args) {
		String str = "we are learning the bad pro language ";
		System.out.println("Numbers of word: " + getNumbersWord(str));
	}
	
	private static int getNumbersWord(String str) {
		String arr[] = str.trim().split("[\\s]+");
		return arr.length;
	}
}
