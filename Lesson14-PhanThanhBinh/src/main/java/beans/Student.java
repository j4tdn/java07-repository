package beans;

import java.util.Objects;

public class Student {
	private String id;
	private String name;
	private String gender;
	public Student() {
		super();
	}
	public Student(String id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return other.getId().equals(getId()) && other.getName().equals(getName()) && other.getGender().equals(getGender());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return id + ", " + name + ", " + gender;
	}
	
}
