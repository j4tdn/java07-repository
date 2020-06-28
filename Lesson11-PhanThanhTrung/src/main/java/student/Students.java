package student;

public class Students {
	private String id;
	private String fullName;
	private float mediumScore;

	public Students() {
		// TODO Auto-generated constructor stub

	}

	public Students(String id, String fullName, float mediumScore) {
		this.id = id;
		this.fullName = fullName;
		this.mediumScore = mediumScore;
	}

	public Students(String fullName) {
		this.fullName = fullName;

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

	public float getMediumScore() {
		return mediumScore;
	}

	public void setMediumScore(float mediumScore) {
		this.mediumScore = mediumScore;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", fullName=" + fullName + ", mediumScore=" + mediumScore + "]";
	}

}
