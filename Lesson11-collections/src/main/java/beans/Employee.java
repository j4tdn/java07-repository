package beans;

import comon.Title;

public class Employee {
	private int Id;
	private String Fullname;
	private int Age;
	private Title title;

	public Employee() {

	}

	public Employee(int id, String fullname, int age, Title title) {
		super();
		Id = id;
		Fullname = fullname;
		Age = age;
		this.title = title;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) { return true;
	 * } if (obj == null || !(obj instanceof Employee)) { return false; } Employee
	 * that = (Employee) obj; return getId()= that.getId(); }
	 */

	@Override
	public String toString() {

		return Id + ", " + Fullname + ", " + Age + ", " + title + " ;";
	}
}
