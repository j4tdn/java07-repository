package test;

public class student {
	private String id;
	private String name;
	private double point;
	private String gender;
	
	public student(String id, String name, double point, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + point + " " + gender;
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

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
