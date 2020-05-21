package sorting;

import java.util.Arrays;
import java.util.Random;

public class Work {
	static int[] input(int index) {
		int[] numbers = new int[index];
		Random rd = new Random();
		for (int i = 0; i < index; i++) {
			numbers[i] = rd.nextInt(20) + 1;
		}
		return numbers;
	}

	static void input(Student[] students) {
		students[0] = new Student("sv01", "Đặng Đình Hoàng", 19);
		students[1] = new Student("sv02", "Nguyễn Văn Hoàng", 20);
		students[2] = new Student("sv03", "Đặng Đình Hoàng", 18);
		students[3] = new Student("sv04", "Dương Chí Mạnh", 17);
		students[4] = new Student("sv05", "Hoàng Văn Khánh", 21);
		students[5] = new Student("sv06", "Nguyễn Quốc Khánh", 17);
		students[6] = new Student("sv07", "Hồ Khanh", 19);
		students[7] = new Student("sv08", "Ngô Bá Khá", 18);
		students[8] = new Student("sv09", "Phan Thành Mạnh", 20);
		students[9] = new Student("sv10", "Phan Thành Trung", 19);
	}

	static void bubleSort(Student[] students, int[] numbers, int index) {
		Student[] std = coppyArray(students, index);
		int[] digits = coppyArray(numbers, index);

		System.out.println(" <> Sắp xếp tăng dần:");
		for (int i = digits.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (digits[j] > digits[j + 1]) {
					swap(digits, j, j + 1);
				}
			}
		}
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		for (int i = std.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				compare(std, j, j + 1);
			}
		}
		Arrays.stream(std).forEach(student -> System.out.println(student));
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		reversed(std);
		Arrays.stream(std).forEach(student -> System.out.println(student));
	}

	static void selectionSort(Student[] students, int[] numbers, int index) {
		Student[] std = coppyArray(students, index);
		int[] digits = coppyArray(numbers, index);
		System.out.println(" <> Sắp xếp tăng dần:");
		for (int i = 0; i < digits.length; i++) {
			for (int j = i + 1; j < digits.length; j++) {
				if (digits[j] < digits[i]) {
					swap(digits, i, j);
				}
			}
		}
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		for (int i = 0; i < std.length; i++) {
			for (int j = i + 1; j < std.length; j++) {
				compare(std, i, j);
			}
		}
		Arrays.stream(std).forEach(student -> System.out.println(student));
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		reversed(std);
		Arrays.stream(std).forEach(student -> System.out.println(student));
	}

	static void insertionSort(Student[] students, int[] numbers, int index) {
		Student[] std = coppyArray(students, index);
		int[] digits = coppyArray(numbers, index);
		System.out.println(" <> Sắp xếp tăng dần:");
		for (int i = 0; i < digits.length; i++) {
			for (int j = 0; j < i; j++) {
				if (digits[i] < digits[j]) {
					swap(digits, i, j);
				}
			}
		}
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		for (int i = 0; i < std.length; i++) {
			for (int j = 0; j < i; j++) {
				compare(std, j, i);
			}
		}
		Arrays.stream(std).forEach(student -> System.out.println(student));
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		reversed(std);
		Arrays.stream(std).forEach(student -> System.out.println(student));
	}

	static void objectSort(Student[] students, int[] numbers, int index) {
		Student[] std = coppyArray(students, index);

		System.out.println(" <> Sắp xếp tăng dần:");
		for (int i = std.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				compare(std, j, j + 1);
			}
		}
		Arrays.stream(std).forEach(student -> System.out.println(student));
		System.out.println();
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(std);
		Arrays.stream(std).forEach(student -> System.out.println(student));
	}

	static void shellSort(int[] numbers, int index) {
		int[] digits = coppyArray(numbers, index);
//		Khoảng cách g = 2^k + 1 (g = 1, 3, 5, 9, 17, ...)
		int g = 0;
		int k = 0;
		do {
			g = (int) Math.pow(2, k++) + 1;
		} while (g < index / 2);
		System.out.println(" <> Sắp xếp tăng dần:");
		for (int i = k; i >= 0;) {
			for (int j = 0; j < g; j++) {
				for (int m = j + g; m < index; m += g) {
					int tmp = digits[m];
					int n = m;
					while (n > j && digits[n - g] > tmp) {
						digits[n] = digits[n - g];
						n -= g;
					}
					if (n < m) {
						digits[n] = tmp;
					}
				}
			}
			i--;
			if (i == 0) {
				g = 1;
			} else {
				g = (int) Math.pow(2, i) + 1;
			}
		}
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
	}

	static void mergeSort(int[] numbers, int index) {
		int[] digits = coppyArray(numbers, index);
		int start = 0;
		int end = index - 1;

		System.out.println(" <> Sắp xếp tăng dần:");
		merge(digits, start, end);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
	}

	private static void merge(int[] digits, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			merge(digits, start, mid);
			merge(digits, mid + 1, end);
			mSort(digits, start, mid, end);
		}
	}

	private static void mSort(int[] digits, int start, int mid, int end) {
		int count = start;
		int[] beforeArr = new int[mid - start + 1];
		int[] afterArr = new int[end - mid];

		for (int i = 0; i < beforeArr.length; i++) {
			beforeArr[i] = digits[start + i];
		}
		for (int i = 0; i < afterArr.length; i++) {
			afterArr[i] = digits[mid + i + 1];
		}
//		Trộn mảng
		int count1 = 0, count2 = 0;
		while (count1 < beforeArr.length && count2 < afterArr.length) {
			digits[count++] = (afterArr[count2] < beforeArr[count1]) ? afterArr[count2++] : beforeArr[count1++];
		}
		while (count1 < beforeArr.length) {
			digits[count++] = beforeArr[count1++];
		}
		while (count2 < afterArr.length) {
			digits[count++] = afterArr[count2++];
		}
	}

	static void quickSort(int[] numbers, int index) {
		int[] digits = coppyArray(numbers, index);
		int start = 0;
		int end = index - 1;
		System.out.println(" <> Sắp xếp tăng dần:");
		quick(digits, start, end);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
	}

	private static void quick(int[] digits, int start, int end) {
		if (start < end) {
			int mid = qSort(digits, start, end);
			quick(digits, start, mid - 1);
			quick(digits, mid + 1, end);
		}
	}

	private static int qSort(int[] digits, int start, int end) {
		int tmp = start - 1;

		for (int i = start; i < end; i++) {
			if (digits[i] < digits[end]) {
				tmp++;
				swap(digits, tmp, i);
			}
		}
		swap(digits, tmp + 1, end);
		return tmp + 1;
	}

	private static int[] coppyArray(int[] numbers, int index) {
		int[] digits = new int[index];
		for (int i = 0; i < index; i++) {
			digits[i] = numbers[i];
		}
		return digits;
	}

	private static Student[] coppyArray(Student[] students, int index) {
		Student[] std = new Student[index];
		for (int i = 0; i < index; i++) {
			std[i] = students[i];
		}
		return std;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	private static void swap(Student[] students, int i, int j) {
		Student tmp = students[i];
		students[i] = students[j];
		students[j] = tmp;
	}

	private static void reversed(int[] numbers) {
		for (int i = 0; i < numbers.length / 2; i++) {
			int tmp = numbers[i];
			numbers[i] = numbers[numbers.length - i - 1];
			numbers[numbers.length - i - 1] = tmp;
		}
	}

	private static void reversed(Student[] students) {
		for (int i = 0; i < students.length / 2; i++) {
			Student tmp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = tmp;
		}
	}

	private static void compare(Student[] std, int index1, int index2) {
		String[] s1 = std[index1].getFullName().split("\\s");// mảng chứa tên của student thứ 1
		String[] s2 = std[index2].getFullName().split("\\s");// mảng chứa tên của student thứ 2
		int minLength = s1.length;
		if (minLength > s2.length) {
			minLength = s2.length;
		}
//		đầu tiên sẽ so sánh tên (2 ptử cuối cùng của 2 mảng)
		int tmp = compareTo(s1[s1.length - 1], s2[s2.length - 1]);
		if (tmp > 0) {
			swap(std, index1, index2);
		} else if (tmp == 0) {
//			nếu trùng tên -> kiểm tra tiếp các ptử còn lại
			for (int i = 0; i < minLength - 1; i++) {
				tmp = compareTo(s1[i], s2[i]);
				if (tmp > 0) {
					swap(std, index1, index2);
					break;
				}
				if (i == minLength - 1) {
					if (s1.length > s2.length) {
						swap(std, index1, index2);
					}
				}
			}
			if (std[index1].getFullName().equals(std[index2].getFullName())) {
				if (std[index1].isAge() > std[index2].isAge()) {
					swap(std, index1, index2);
				}
			}
		}
	}

	private static int compareTo(String s1, String s2) {
		int minLength = s1.length();
		if (minLength > s2.length()) {
			minLength = s2.length();
		}
		String[] str1 = s1.split("");
		String[] str2 = s2.split("");
		int calculate = 0;
		for (int i = 0; i < minLength; i++) {
			int char1 = getValue(str1[i]);
			int char2 = getValue(str2[i]);
			if (char1 < char2) {
				return -1;
			}
			if (char1 > char2) {
				calculate = char1 - char2;
				return calculate;
			}
		}
		return 0;
	}

	private static int getValue(String str) {
		int value = 0;
		String[][] charecters = { { "a", "1" }, { "á", "2" }, { "à", "3" }, { "ả", "4" }, { "ã", "5" }, { "ạ", "6" },
				{ "â", "7" }, { "ấ", "8" }, { "ầ", "9" }, { "ẩ", "10" }, { "ẫ", "11" }, { "ậ", "12" }, { "ă", "13" },
				{ "ắ", "14" }, { "ằ", "15" }, { "ẳ", "16" }, { "ẵ", "17" }, { "ặ", "18" }, { "b", "19" }, { "c", "20" },
				{ "d", "21" }, { "đ", "22" }, { "e", "23" }, { "é", "24" }, { "è", "25" }, { "ẻ", "26" }, { "ẽ", "27" },
				{ "ẹ", "28" }, { "ê", "29" }, { "ế", "30" }, { "ề", "31" }, { "ể", "32" }, { "ễ", "33" }, { "ệ", "34" },
				{ "g", "35" }, { "h", "36" }, { "i", "37" }, { "í", "38" }, { "ì", "39" }, { "ỉ", "40" }, { "ĩ", "41" },
				{ "ị", "42" }, { "k", "43" }, { "l", "44" }, { "m", "45" }, { "n", "46" }, { "o", "47" }, { "ó", "48" },
				{ "ò", "49" }, { "ỏ", "50" }, { "õ", "51" }, { "ọ", "52" }, { "ô", "53" }, { "ố", "54" }, { "ồ", "55" },
				{ "ổ", "56" }, { "ỗ", "57" }, { "ộ", "58" }, { "ơ", "59" }, { "ớ", "60" }, { "ờ", "61" }, { "ở", "62" },
				{ "ỡ", "63" }, { "ợ", "64" }, { "p", "65" }, { "q", "66" }, { "r", "67" }, { "s", "68" }, { "t", "69" },
				{ "u", "70" }, { "ú", "71" }, { "ù", "72" }, { "ủ", "73" }, { "ũ", "74" }, { "ụ", "75" }, { "ư", "76" },
				{ "ứ", "77" }, { "ừ", "78" }, { "ử", "79" }, { "ữ", "80" }, { "ự", "81" }, { "v", "82" }, { "x", "83" },
				{ "y", "84" }, { "ý", "85" }, { "ỳ", "86" }, { "ỷ", "87" }, { "ỹ", "88" }, { "ỵ", "89" }, { "A", "99" },
				{ "Á", "100" }, { "À", "101" }, { "Ả", "102" }, { "Ã", "103" }, { "Ạ", "104" }, { "Â", "105" },
				{ "Ấ", "106" }, { "Ầ", "107" }, { "Ẩ", "108" }, { "Ẫ", "109" }, { "Ậ", "110" }, { "Ă", "111" },
				{ "Ắ", "112" }, { "Ằ", "113" }, { "Ẳ", "114" }, { "Ẵ", "115" }, { "Ặ", "116" }, { "B", "117" },
				{ "C", "118" }, { "D", "119" }, { "Đ", "120" }, { "E", "121" }, { "É", "122" }, { "È", "123" },
				{ "Ẻ", "124" }, { "Ẽ", "125" }, { "Ẹ", "126" }, { "Ê", "127" }, { "Ế", "128" }, { "Ề", "129" },
				{ "Ể", "130" }, { "Ễ", "131" }, { "Ệ", "132" }, { "G", "133" }, { "H", "134" }, { "I", "135" },
				{ "Í", "136" }, { "Ì", "137" }, { "Ỉ", "138" }, { "Ĩ", "139" }, { "Ị", "140" }, { "K", "141" },
				{ "L", "142" }, { "M", "143" }, { "N", "144" }, { "O", "145" }, { "Ó", "146" }, { "Ò", "147" },
				{ "Ỏ", "148" }, { "Õ", "149" }, { "Ọ", "150" }, { "Ô", "151" }, { "Ố", "152" }, { "Ồ", "153" },
				{ "Ổ", "154" }, { "Ỗ", "155" }, { "Ộ", "156" }, { "Ơ", "157" }, { "Ớ", "158" }, { "Ờ", "159" },
				{ "Ở", "160" }, { "Ỡ", "161" }, { "Ợ", "162" }, { "P", "163" }, { "Q", "164" }, { "R", "154" },
				{ "S", "166" }, { "T", "167" }, { "U", "168" }, { "Ú", "169" }, { "Ù", "170" }, { "Ủ", "171" },
				{ "Ũ", "172" }, { "Ụ", "173" }, { "Ư", "174" }, { "Ứ", "175" }, { "Ừ", "176" }, { "Ử", "177" },
				{ "Ữ", "178" }, { "Ự", "179" }, { "V", "180" }, { "X", "181" }, { "Y", "182" }, { "Ý", "183" },
				{ "Ỳ", "184" }, { "Ỷ", "185" }, { "Ỹ", "186" }, { "Ỵ", "187" } };
		for (int i = 0; i < charecters.length; i++) {
			if (str.equals(charecters[i][0])) {
				value = Integer.parseInt(charecters[i][1]);
				break;
			}
		}
		return value;
	}
}