package bean;

public class Student {
	private Integer id;
	private String fullname;
	private Double point;

	public Student() {
	}

	public Student(int id, String fullname, double point) {
		this.id = id;
		this.fullname = fullname;
		this.point = point;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return id + " " + fullname + " " + point;
	}
	
}
