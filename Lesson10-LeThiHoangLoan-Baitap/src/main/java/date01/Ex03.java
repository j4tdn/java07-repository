package date01;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", "4", "8", "Special", "a", "b", "-112", "c", "xx" };
		sort(strings, Sort.DESC);
		Arrays.stream(strings).forEach(student -> System.out.print(student + "  "));
	}

	private static void sort(String[] strings, Sort sort) {
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == "Special") {
				continue;
			}
			for (int j = strings.length - 1; j > i; j--) {
				if (strings[j] == "Special") {
					String tmp = strings[i];
					strings[i] = strings[j];
					strings[j] = tmp;
					break;
				}

				else if (strings[i].charAt(0) == 45 || (strings[i].charAt(0) >= 48 && strings[i].charAt(0) <= 57)) {
					if (strings[j].charAt(0) == 45 || (strings[j].charAt(0) >= 48 && strings[j].charAt(0) <= 57)) {

						int a = Integer.parseInt(strings[i].substring(0));
						int b = Integer.parseInt(strings[j].substring(0));

						if (a > b) {
							String tmp = strings[j];
							strings[j] = strings[i];
							strings[i] = tmp;
						}
					}

				} else {
					int comparision = strings[i].compareTo(strings[j]);
					if (comparision > 0) {
						String tmp = strings[j];
						strings[j] = strings[i];
						strings[i] = tmp;
					}
				}
			}
		}

		if (Sort.DESC.equals(sort)) {
			reversed(strings);
		}
	}

	private static void reversed(String[] students) {
		for (int i = 0; i < students.length / 2; i++) {
			String tmp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = tmp;
		}
	}
}
