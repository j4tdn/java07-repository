package java07.Lesson09_PhamHoaMau;

public class Ex03 {

	public static void main(String[] args) {
		String students = "102-Nam-C, 104-Hoàng-D, 109-Lan-A, 103-Bảo-F, 105-Nguyên-B, 103-Bảo-F, 107-Vũ-F";
		showStudentsOnlyLearnOnce(students);
		System.out.println("-----------------------");
		showStudentsOnlyLearnOnceAndRatedA(students);
	}

	private static void showStudentsOnlyLearnOnce(String students) {
		int count = 0;
		boolean flag = true;
		for (int i = 0; i < students.length(); i++) {
			if (students.charAt(i) == ',') {
				count += 1;
			}
		}
		String[] input = new String[count + 1], studentCode = new String[count + 1];
		input = students.split(", ");
		for (int i = 0; i < input.length; i++) {
			studentCode[i] = input[i].substring(0, 3);
		}
		for (int i = 0; i < studentCode.length; i++) {
			flag = true;
			for (int j = 0; j < studentCode.length; j++) {
				if (i == j) {
					continue;
				} else {
					if ((studentCode[i].equals(studentCode[j]))) {
						flag = false;
					}
				}
			}
			if (flag) {
				System.out.println(input[i]);
			}
		}
	}

	private static void showStudentsOnlyLearnOnceAndRatedA(String students) {
		int count = 0;
		boolean flag;
		for (int i = 0; i < students.length(); i++) {
			if (students.charAt(i) == ',') {
				count += 1;
			}
		}
		String[] input = new String[count + 1], rated = new String[count + 1];
		input = students.split(", ");
		for (int i = 0; i < input.length; i++) {
			rated[i] = input[i].substring(input[i].length() - 1, input[i].length());
		}
		for (int i = 0; i < rated.length; i++) {
			if ("A".equals(rated[i])) {
				System.out.println(input[i]);
			}
		}
	}
}
