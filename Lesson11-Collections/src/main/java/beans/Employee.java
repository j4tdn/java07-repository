package beans;

import common.Title;

public class Employee {
	private int id;
	private String fullname;
	private int age;
	private Title title;

	public Employee() {

	}

	public Employee(int id, String fullname, int age, Title title) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.age = age;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Employee)) {
			return false;
		}
		Employee that = (Employee) obj;
		return getId() == that.getId();
	}

	@Override
	public String toString() {
		return id + ",  " + fullname + ",  " + age + ",  " + title;
	}
}
