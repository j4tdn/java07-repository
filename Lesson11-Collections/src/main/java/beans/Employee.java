package beans;

import common.Title;

public class Employee {
	private int id;
	private String fullName;
	private int age;
	private Title titel;

	public Employee() {
	}

	public Employee(int id, String fullName, int age, Title titel) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.titel = titel;
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

	public Title getTitel() {
		return titel;
	}

	public void setTitel(Title titel) {
		this.titel = titel;
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
		return id + " - " + fullName + ", " + age + ", " + titel;
	}
}