package sorting;

import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[] numbers = random(10);
		Student[] students = new Student[6];
		input(students);
		objectSort(students);
		Arrays.stream(students).forEach(student -> System.out.println(student));
		System.out.println("==================================");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println();
		// bubleSort(numbers);
		// selectionSort(numbers);
		// inserSort(numbers);
		// shellSort(numbers);
		// mergeSort(numbers);
		quickSort(numbers);//bạn thích chạy cái nào thì mở cmt ra nhé.
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));

	}

	private static int[] random(int len) {
		int[] number = new int[len];
		Random rd = new Random();

		for (int i = 0; i < len; i++) {
			number[i] = rd.nextInt(100) + 1;
		}
		return number;
	}

	private static void bubleSort(int[] numbers) {
		for (int i = numbers.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					swap(numbers, j, j + 1);
				}
			}
		}
	}

	private static void selectionSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					swap(numbers, i, j);
				}
			}
		}
	}

	private static void inserSort(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			for (int j = 0; j < i; j++) {
				if (numbers[i] < numbers[j]) {
					swap(numbers, i, j);
				}
			}
		}
	}

	static void shellSort(int[] numbers) {
		int index = numbers.length;
		int g = 0;
		int k = 0;
		do {
			g = (int) Math.pow(2, k++) + 1;
		} while (g < index / 2);
		for (int i = k; i >= 0;) {
			for (int j = 0; j < g; j++) {
				for (int m = j + g; m < index; m += g) {
					int tmp = numbers[m];
					int n = m;
					while (n > j && numbers[n - g] > tmp) {
						numbers[n] = numbers[n - g];
						n -= g;
					}
					if (n < m) {
						numbers[n] = tmp;
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
	}

	static void mergeSort(int[] numbers) {
		int index = numbers.length;
		int start = 0;
		int end = index - 1;
		merge(numbers, start, end);
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

	static void quickSort(int[] numbers) {
		int index = numbers.length;
		int start = 0;
		int end = index - 1;
		quick(numbers, start, end);
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

	static void objectSort(Student[] students) {
		for (int i = students.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				compare(students, j, j + 1);
			}
		}

	}

	private static void input(Student[] students) {
		students[0] = new Student("sv01", "Phan Thành Trung", 22);
		students[1] = new Student("sv02", "Phan Văn Trung", 12);
		students[2] = new Student("sv03", "Đặng Đình Hoàng", 22);
		students[3] = new Student("sv04", "Nguyễn Quốc Trung", 24);
		students[4] = new Student("sv05", "Hoàng Văn Khánh", 23);
		students[5] = new Student("sv06", "Đoàn Mai Khánh", 52);
	}

	private static void compare(Student[] std, int index1, int index2) {
		String[] s1 = std[index1].getName().split("\\s");// mảng chứa tên của student thứ 1
		String[] s2 = std[index2].getName().split("\\s");// mảng chứa tên của student thứ 2
		int minLength = s1.length;
		if (minLength > s2.length) {
			minLength = s2.length;
		}

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
			if (std[index1].getName().equals(std[index2].getName())) {
				if (std[index1].getAge() > std[index2].getAge()) {
					swap(std, index1, index2);
				}
			}
		}
	}

	private static void swap(Student[] std, int index1, int index2) {
		Student st = std[index1];
		std[index1] = std[index2];
		std[index2] = st;

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

	private static void swap(int[] numbers, int i, int j) {
		// TODO Auto-generated method stub
		int number = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = number;
	}

}
