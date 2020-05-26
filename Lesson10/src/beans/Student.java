package beans;

public class Student {
	private String id;
	private String fullname;
	private double avg;
	private boolean gender;

	public Student() {
		super();
	}

	public Student(String id, String fullname, double avg, boolean gender) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.avg = avg;
		this.gender = gender;
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
		return "id=" + id + ", fullname=" + fullname + ", avg=" + avg + ", gender=" + gender ;
	}
	
}
