package java07.Lesson09_submit;

public class Bt03 {
	public static void main(String[] args) {
		String[] users = { "102-Nam-C", "04-Hoàng-D", "109-Lan-A", "103-Bảo-F", "105-Nguyên-B", "107-Vũ-F", "103-Bảo-F",
				"202-Đạt-C", "107-Vũ-C", "193-Bảo-C", "199-Tài-A" };

		for (String user : users) {
			String[] array = user.split(",", 3);
			for (int i = 0; i < array.length - 1; i++) {
				for (int j = i + 1; j < array.length; j++) {

				}
			}
		}
	}

}

class Student {
	private String number;
	private String name;
	private String point;

	public Student() {

	}

	public Student(String number, String name, String point) {
		super();
		this.number = number;
		this.name = name;
		this.point = point;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	@Override
	public String toString() {

		return String.join("--", "number", "name", "point");
	}
}
