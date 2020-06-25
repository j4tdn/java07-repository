package bt.b1;

import java.util.Objects;

public class Student {
	private String id;
	private String name;
	private double average;

	public Student() {

	}

	public Student(String id, String name, double average) {
		super();
		this.id = id;
		this.name = name;
		this.average = average;
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

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "MSSV: " + id + " - " + "Ho ten: " + name + " - " + "DTB: " + average;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Student)) {
			return false;
		}
		Student that = (Student) obj;
		return getId() == that.getId();
	}
}
