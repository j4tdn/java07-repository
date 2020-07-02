package view;

import java.util.Objects;

public class Student {

	private String id;
	private String name;
	private float avg;
	private String gender;

	public Student() {
	}

	public Student(String id, String name, float avg, String gender) {
		this.id = id;
		this.name = name;
		this.avg = avg;
		this.gender = gender;
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

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, avg, gender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Student))
			return false;
		Student st = (Student) obj;

		return st.getId().equals(this.getId());
	}

	@Override
	public String toString() {
		return id + ", " + name + "," + avg + ", " + gender;
	}
}
