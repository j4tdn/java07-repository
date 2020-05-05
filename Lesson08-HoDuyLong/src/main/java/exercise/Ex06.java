package exercise;

public class Ex06 {
	public static void main(String[] args) {
		getNumber(10);
	}

	private static void getNumber(int k) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1 ; i <= k ; i++) {
			sb.append(i);
		}
		System.out.println("The number: " + sb.toString());
		System.out.println("The number at position " + k + ":" + sb.charAt(k - 1));
	}
}
