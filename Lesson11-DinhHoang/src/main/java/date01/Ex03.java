package date01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import beans.Student;

public class Ex03 {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(" ____________________________________________________________");
			System.out.println("|>>>>>>>>>>>>>>>>>    QUẢN LÝ SINH VIÊN    <<<<<<<<<<<<<<<<<<|");
			System.out.println("|1. Nhập danh sách sinh viên.                                |");
			System.out.println("|2. Xem danh sách sinh viên.                                 |");
			System.out.println("|3. Sắp xếp và hiển thị DSSV theo chiều tăng dần của điểm TB.|");
			System.out.println("|4. Sắp xếp và hiển thị DSSV theo bằng chữ cái alphabet.     |");
			System.out.println("|5. Thêm SV vào danh sách. Có thể [1||n] SV.                 |");
			System.out.println("|6. Tìm kiếm sinh viên theo mã.                              |");
			System.out.println("|7. Xóa một sinh viên bị đuổi học khỏi danh sách.            |");
			System.out.println("|0. Exit.                                                    |");
			System.out.println("|____________________________________________________________|");
			System.out.print(" > Nhập 1 lựa chọn: ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 0:
				System.exit(0);
				break;
			case 1:
				System.out.println("NHẬP DANH SÁCH SINH VIÊN:");
				input(students);
				break;
			case 2:
				System.out.println("DANH SÁCH SINH VIÊN:");
				output(students);
				break;
			case 3:
				System.out.println("SẮP XẾP SV TĂNG DẦN THEO ĐIỂM TB:");
				sortedByScore(students);
				break;
			case 4:
				System.out.println("SẮP XẾP SV TĂNG DẦN THEO ĐIỂM ALPHABET:");
				sortedByAlpha(students);
				break;
			case 5:
				System.out.println("THÊM SINH VIÊN VÀO DSSV:");
				input(students);
				break;
			case 6:
				System.out.println("TÌM KIẾM SV THEO MÃ SV:");
				search(students);
				break;
			case 7:
				System.out.println("XÓA MỘT SV KHỎI DANH SÁCH:");
				remove(students);
				break;
			default:
				System.out.println("Nhập vào 1 số từ 0 -> 7 !");
			}
		} while (true);
	}

	private static void input(List<Student> std) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (true) {
			Student student = new Student();
			System.out.print((++count) + ". Nhập mã sv   : ");
			do {
				String id = sc.nextLine();
				if (checkId(std, id)) {
					student.setId(id);
					break;
				}
				System.out.print("- Nhập mã sv    : ");
			} while (true);
			System.out.print("- Nhập họ tên sv: ");
			String fullName = sc.nextLine();
			student.setFullName(fullName);
			System.out.print("- Nhập điểm TB  : ");
			float mediumScore = Float.parseFloat(sc.nextLine());
			student.setMediumScore(mediumScore);
			std.add(student);
			System.out.println("Nhập 1 để tiếp tục NHẬP or nhập 0 để THOÁT!");
			int select = Integer.parseInt(sc.nextLine());
			if (select == 0) {
				break;
			}
		}
	}

	private static boolean checkId(List<Student> std, String id) {
		for (Student s : std) {
			if (id.equals(s.getId())) {
				return false;
			}
		}
		return true;
	}

	private static void output(List<Student> std) {
		for (int i = 0; i < std.size(); i++) {
			System.out.println((i + 1) + ". " + std.get(i));
		}
	}

	private static void sortedByScore(List<Student> std) {
		List<Student> students = new ArrayList<>(std);
		students.sort((s1, s2) -> String.valueOf(s1.getMediumScore()).compareTo(String.valueOf(s2.getMediumScore())));
		output(students);
	}

	private static void sortedByAlpha(List<Student> std) {
		List<Student> students = new ArrayList<>(std);
		students.sort((std1, std2) -> {
			String[] s1 = std1.getFullName().split("\\s");
			String[] s2 = std2.getFullName().split("\\s");
			int minLength = s1.length;
			if (minLength > s2.length) {
				minLength = s2.length;
			}
			int tmp = compareTo(s1[s1.length - 1], s2[s2.length - 1]);
			if (tmp > 0) {
				return tmp;
			} else if (tmp == 0) {
				for (int i = 0; i < minLength - 1; i++) {
					tmp = compareTo(s1[i], s2[i]);
					if (tmp > 0) {
						return tmp;
					}
					if (i == minLength - 1) {
						if (s1.length > s2.length) {
							return tmp;
						}
					}
				}
			}
			return -1;
		});
		output(students);
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

	private static void search(List<Student> std) {
		do {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhập mã sv cần tìm: ");
			String id = sc.nextLine();
			System.out.println("Kết quả tìm kiếm:");
			int tmp = 0;
			for (Student student : std) {
				if (id.equals(student.getId())) {
					System.out.println("- " + student);
					tmp++;
					break;
				}
			}
			if (tmp == 1) {
				break;
			}
			System.out.println("Mã sv không hợp lệ!");
		} while (true);
	}

	private static void remove(List<Student> std) {
		do {
			System.out.print("Nhập mã sv cần xóa: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String id = sc.nextLine();
			if (removeIf(std, id)) {
				System.out.println("Đã xóa sv \"" + id + "\"!");
				break;
			}
			System.out.println("Mã sv không hợp lệ!");
		} while (true);
	}

	private static boolean removeIf(List<Student> std, String id) {
		boolean removed = false;
		Iterator<Student> each = std.iterator();
		while (each.hasNext()) {
			if (id.equals(each.next().getId())) {
				each.remove();
				removed = true;
			}
		}
		return removed;
	}
}