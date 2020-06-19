package beans;

import java.util.Objects;

public class Student {
	private String id; 
	private String fullname;
	private float average;
	public Student() {
		super();
	}
	public Student(String id, String fullname, float average) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.average = average;
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
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
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
		if (obj == null || !(obj instanceof Student));
		Student s = (Student) obj;
		return s.getId().equals(getId());
	}
	@Override
	public String toString() {
		return id + " " + fullname + " " + average;
	}
	
}
