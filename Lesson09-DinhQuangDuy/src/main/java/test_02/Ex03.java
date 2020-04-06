package test_02;

import java.util.ArrayList;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) {
		String[] students = { "102-Nam-C", "104-Hoàng-D", "109-Lan-A", "103-Bảo-F", "105-Nguyên-B", "107-Vũ-F",
				"103-Bảo-F", "202-Đạt-C", "107-Vũ-C", "193-Bảo-B", "199-Tài-A" };

		List<Student> studentsLearnOnce = searchStudentsLearnOnce(students);
		showStudentsLearnOnce(studentsLearnOnce);
		System.out.println("===========================================");
		searchStudentsLeanOnceScoreA(studentsLearnOnce);
	}

	private static void showStudentsLearnOnce(List<Student> students) {
		System.out.println("---Student learn once---");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static void searchStudentsLeanOnceScoreA(List<Student> students) {
		System.out.println("---Student learn once and score A---");
		for (Student student : students) {
			if ("A".equals(student.getScores())) {
				System.out.println(student);
			}
		}
	}

	private static List<Student> searchStudentsLearnOnce(String[] strings) {
		Student[] students = new Student[strings.length];
		List<Student> studentsLearnOnce = new ArrayList<Student>();
		int index = 0;

		for (String string : strings) {
			String[] substringStudent = string.split("-");
			students[index] = new Student(substringStudent[0], substringStudent[1], substringStudent[2]);
			index++;
		}

		boolean isLearnOnce;

		for (int i = 0; i < students.length; i++) {
			isLearnOnce = false;
			for (int j = 0; j < students.length; j++) {
				if (i == j) {
					continue;
				}

				if (students[i].getId().equals(students[j].getId())) {
					isLearnOnce = true;
					break;
				}
			}
			
			if (!isLearnOnce) {
				studentsLearnOnce.add(students[i]);
			}
		}

		return studentsLearnOnce;
	}
}

class Student {
	private String id;
	private String fullname;
	private String scores;

	public Student(String id, String fullname, String scores) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.scores = scores;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {

		return "Id " + this.id + ", Fullname " + this.fullname + ", score " + this.scores;
	}

}
