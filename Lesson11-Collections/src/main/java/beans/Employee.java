package beans;

import javax.swing.border.TitledBorder;

import common.Title;

public class Employee {
	private int id;
	private String fullName;
	private int age;
	private Title title;

	public Employee() {
		super();
	}

	public Employee(int id, String fullName, int age, Title title) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String toString() {
		return "id=" + id + ", fullName=" + fullName + ", age=" + age + ", title=" + title;
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
}
