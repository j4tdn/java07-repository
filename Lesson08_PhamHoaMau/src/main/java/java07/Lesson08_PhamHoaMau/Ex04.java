package java07.Lesson08_PhamHoaMau;

public class Ex04 {
	public static void main(String[] args) {
		long numberOne = 7936110, numberTwo = 2142749700;
		String s1 = separatePrimeNumber(numberOne), s2 = separatePrimeNumber(numberTwo);
		System.out.println(s1.equals(s2) ? "YES" : "NO");
	}

	private static String separatePrimeNumber(long number) {
		int index = 2;
		String string = "";
		while (number > 1) {
			if (number % index == 0 && isPrimeNumber(index)) {
				number /= index;
				if (!string.contains(Integer.toString(index))) {
					string += Integer.toString(index);
				}
			} else {
				index++;
			}
		}
		return string;
	}

	private static boolean isPrimeNumber(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}