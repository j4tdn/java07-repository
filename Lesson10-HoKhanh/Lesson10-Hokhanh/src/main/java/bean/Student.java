package bean;

public class Student  {
	private String id;
	private String fullname;
	private boolean gender;
	private double avg;

	public Student() {
	}

	public Student(String id, String fullname, double avg, boolean gender) {
		this.id = id;
		this.fullname = fullname;
		this.gender = gender;
		this.avg = avg;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
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

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return id + "," + fullname + "," + gender + "," + avg;
	}

}
