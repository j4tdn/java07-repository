package beans;

public class Students {
	private String id;
	private String fullname;
	private double averagePoint;
	private boolean gender;
	
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
	public double getAveragePoint() {
		return averagePoint;
	}
	public Students(String id, String fullname, double averagePoint, boolean gender) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.averagePoint = averagePoint;
		this.gender = gender;
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setAveragePoint(double averagePoint) {
		this.averagePoint = averagePoint;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return id + ", " + fullname + ", " + averagePoint + ", " + gender;
	}
	
	
}
