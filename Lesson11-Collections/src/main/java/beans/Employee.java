package beans;

import common.Title;

public class Employee {
	private int id;
	private String fulname;
	private int age;
	private Title title;

	public Employee(int id, String fulname, int age, Title title) {
		super();
		this.id = id;
		this.fulname = fulname;
		this.age = age;
		this.title = title;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFulname() {
		return fulname;
	}

	public void setFulname(String fulname) {
		this.fulname = fulname;
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof Employee)) {
			return false;
		}
		Employee that = (Employee) o;
		return getId() == that.getId();
	}

	@Override
	public String toString() {
		return id + "," + fulname + "," + age + "," + title;
	}
}
