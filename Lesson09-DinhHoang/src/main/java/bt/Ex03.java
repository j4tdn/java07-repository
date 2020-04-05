package bt;

public class Ex03 {

	public static void main(String[] args) {
		Students[] students = new Students[11];
		token(students);
		int temp = 0;
		for (int i = 0; i < students.length; i++) {
			if (i == students.length - 1) {
				for (int k = 0; k < students.length; k++) {
					if (students[i].getCode().equals(students[k].getCode())) {
						temp++;
					}
				}
				if ("A".equals(students[i].getClassification())) {
					System.out.println("DSSV học một lần và xếp loại A để khen thưởng: " + students[i].toString());
				}
			}
			for (int j = i + 1; j < students.length; j++) {
				if (students[i].getCode().equals(students[j].getCode())
						&& students[i].getFullName().equals(students[j].getFullName())) {
					System.out.println("DSSV chỉ đăng ký học một lần trong năm 2018: " + students[i].toString());
				}
				if (students[i].getCode().equals(students[j].getCode())) {
					temp++;
				}
			}
			if (temp == 0 && "A".equals(students[i].getClassification())) {
				System.out.println("DSSV học một lần và xếp loại A để khen thưởng: " + students[i].toString());
			}
		}
	}

	private static void token(Students[] students) {
		String std = "102-Nam-C, 104-Hoàng-D, 109-Lan-A, 103-Bảo-F, 105-Nguyên-B, 107-Vũ-F, 103-Bảo-F, 202-Đạt-C, 107-Vũ-C, 193-Bảo-B, 199-Tài-A";
		String[] stds = std.split(", ");
		for (int i = 0; i < stds.length; i++) {
			String[] s = stds[i].split("-");
			students[i] = new Students(s[0], s[1], s[2]);
		}
	}
}