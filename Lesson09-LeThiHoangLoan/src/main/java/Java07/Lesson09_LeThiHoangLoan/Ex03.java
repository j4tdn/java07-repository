package Java07.Lesson09_LeThiHoangLoan;

public class Ex03 {

	public static void main(String[] args) {
		String students = "102-Nam-C, 104-Hoàng-D, 109-Lan-A, 103-Bảo-F, 105-Nguyên-B, 107-Vũ-F, 103-Bảo-F, 202-Đạt-C, 107-Vũ-C, 193-Bảo-B, 199-Tài-A";
		String[] student = students.split(",\\s");
		System.out.println("Danh sach sv dang ki mot lan:");
		for (int i = 0; i < student.length; i++) {
			boolean bl = true;
			for (int j = 0; j < student.length; j++) {
				if (i != j) {
					if (student[i].substring(0, 3).equals(student[j].substring(0, 3))) {
						bl = false;
					}
				}

			}
			if (bl == true) {
				System.out.println(student[i]);
			}
		}

	}
}


