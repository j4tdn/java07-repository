package Been;

import java.util.Objects;

import commom.Tetle;

public class Employee {
	private int id;
	private String fullName;
	private int age;
	private Tetle title;

	public Employee() {
		// TODO Auto-generated constructor stub
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

	public Tetle getTitle() {
		return title;
	}

	public void setTitle(Tetle title) {
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

	public Employee(int id, String fullName, int age, Tetle title) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", age=" + age + ", title=" + title + "]";
	}
	public int hashCode() {
		return Objects.hash(id);
	}

}
