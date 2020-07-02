package test;

import java.util.Objects;


public class Student {
	private String id;
	private String name;
	private float point;
	private String gender;

	public Student() {
	}

	public Student(String id, String name, float point, String gender) {
		this.id = id;
		this.name = name;
		this.point = point;
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

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,name,point,gender);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Student)) {
			return false;
		}
		Student t = (Student) o;
		return getId().equals(t.getId()) && getName().equals(t.getName()) && getPoint() == t.getPoint()
				&& getGender().equals(t.getGender());
	}

}
