import java.awt.datatransfer.StringSelection;
import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", "8", "4", "special", "a", "c", "b", "xx" };
		sortAsc(strings);
		System.out.println("sap xep tang dan");
		Arrays.stream(strings).forEach(string -> System.out.print(string + " "));
		System.out.println("\nsap xep giam dan : ");
		sortDes(strings);
		Arrays.stream(strings).forEach(string -> System.out.print(string + " "));
	}

	private static void sortAsc(String[] strings) {

		for (int i = 0; i < strings.length - 1; i++) {
			for (int j = i + 1; j < strings.length; j++) {
				if (strings[i].equals("special")) {
					break;

				}
				if (strings[j].equals("special")) {
					swap(strings, i, j);
					break;
				}
				if (isNumber(strings[i]) && isNumber(strings[j])) {
					if (Integer.parseInt(strings[i]) > Integer.parseInt(strings[j])) {
						swap(strings, i, j);
					}
				} else if (strings[i].compareTo(strings[j]) > 0) {// chuyen sang bang ma ascii roi tru
					swap(strings, i, j);
				}
			}
		}
	}

	public static void swap(String[] strings, int i, int j) {
		String tmp = strings[i];
		strings[i] = strings[j];
		strings[j] = tmp;

	}

	private static boolean isNumber(String strings) {
		if (strings.substring(0, 1).equals("-") && strings.length() > 1) {
			String tmp = strings.substring(1);
			if (number(tmp)) {
				return true;
			}
		}
		if (number(strings)) {
			return true;
		}
		return false;
	}

	private static boolean number(String tmp) {
		for (int i = 0; i < tmp.length(); i++) {
			if (!"0123456789".contains(tmp.substring(i, i + 1))) {
				return false;
			}
		}
		// TODO Auto-generated method stub
		return true;
	}

	private static void sortDes(String[] strings) {
		for (int i = 0; i < strings.length / 2; i++) {
			String tmp = strings[i];
			strings[i] = strings[strings.length - i - 1];
			strings[strings.length - 1 - i] = tmp;

		}
	}
}
