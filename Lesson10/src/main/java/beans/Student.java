package beans;

public class Student {
	private String id;
	private String fullName;
	private double avg;
	private boolean gender;

	public Student() {

	}

	public Student(String id, String fullName, double avg, boolean gender) {
		this.id = id;
		this.fullName = fullName;
		this.avg = avg;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return id + ", " + fullName + "," + avg + ", " + gender;
	}

}
