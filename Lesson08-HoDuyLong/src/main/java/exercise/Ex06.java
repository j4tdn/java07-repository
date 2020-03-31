package exercise;

public class Ex06 {
	public static void main(String[] args) {
		String numberString = "1234894512314599663214554787777845412354798422122";

		getNumber(numberString, 30);
	}

	private static void getNumber(String s, int k) {
		int result = 0;
		result = Character.getNumericValue(s.charAt(k - 1));
		System.out.println(result);
	}
}
