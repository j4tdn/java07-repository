package views;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex03 extends Student {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		ArrayList<Student> students = new ArrayList<Student>();
		list.add(new Student("101", "Vuong1", "A"));
		list.add(new Student("102", "Vuong2", "A"));
		list.add(new Student("103", "Vuong3", "F"));
		list.add(new Student("104", "Vuong4", "B"));
		list.add(new Student("102", "Vuong5", "D"));
		list.add(new Student("106", "Vuong6", "A"));
		list.add(new Student("102", "Vuong2", "F"));
		list.add(new Student("108", "Vuong8", "C"));
		list.add(new Student("103", "Vuong9", "B"));
		list.add(new Student("110", "Vuong10", "A"));
		System.out.println("Danh sách sinh viên đăng kí một lần:");
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if ((list.get(i).id).equals((list.get(j).id))) {

					students.add(new Student(list.get(i).id, list.get(i).fullname, list.get(i).point));
				}
			}
		}
		ArrayList<Student> arrTemp = new ArrayList<Student>();
		for (Student eleme : students) {
			if (!arrTemp.contains(eleme)) {
				arrTemp.add(eleme);
			}
		}
		System.out.println("Các phần tử có trong arrListNumber là: ");
		for (int i = 0; i < arrTemp.size(); i++) {
			System.out.println(arrTemp.get(i).id);
			System.out.println(arrTemp.get(i).fullname);
			System.out.println(arrTemp.get(i).point);
		}

	}

}

class Student {
	String id, fullname, point;

	public Student(String id, String fullname, String point) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.point = point;
	}

	public Student() {
		super();
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

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}



}
