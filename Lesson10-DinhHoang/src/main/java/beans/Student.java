package beans;

public class Student {
	private String id;
	private String fullName;
	private boolean gender;
	private float avg;

	public Student() {
	}

	public Student(String id, String fullName, boolean gender, float avg) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.avg = avg;
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

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return id + " - " + fullName + " - " + gender + " - " + avg;
	}
}