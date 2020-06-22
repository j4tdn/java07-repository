package beans;

import java.util.Objects;

public class Student {
	private String id;
	private String fullName;
	private float mediumScore;

	public Student() {
	}

	public Student(String id, String fullName, float mediumScore) {
		this.id = id;
		this.fullName = fullName;
		this.mediumScore = mediumScore;
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
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof Student) {
			return false;
		}
		Student std = (Student) obj;
		return std.getId().equals(getId()) && std.getFullName().equals(getFullName())
				&& std.getMediumScore() == getMediumScore();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fullName, mediumScore);
	}

	@Override
	public String toString() {
		return "Mã sv    : " + id + "\n" +
			   "- Họ tên SV: " + fullName + "\n" +
			   "- Điểm TB  : " + mediumScore;
	}
}