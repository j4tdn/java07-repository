package beans;

import java.util.Objects;

public class Student {
	private int id;
	private String name;
	private float average;
	private boolean gender;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, float average, boolean gender) {
		super();
		this.id = id;
		this.name = name;
		this.average = average;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", average=" + average + ", gender=" + gender + "]";
	}
	
	
	
	
	
	

}
