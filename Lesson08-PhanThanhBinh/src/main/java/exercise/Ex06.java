package exercise;

public class Ex06 {
	private static final int number = 1000;
	public static void main(String[] args) {
		System.out.println(getNumber(showNumber(), 100));
	}
	
	private static int getNumber(StringBuilder str,int k) {
		return str.charAt(k - 1) - '0';
	}
	
	private static StringBuilder showNumber() {
		StringBuilder result = new StringBuilder("");
		for(int  i = 1; i < number; i++) {
			result = result.append(i);
		}
		return result;
	}
}
