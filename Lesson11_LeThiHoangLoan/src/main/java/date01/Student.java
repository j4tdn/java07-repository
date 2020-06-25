package date01;

import java.util.Objects;

public class Student {
	private String id;
	private String fullName;
	private Double mediumScore;

	public Student() {

	}

	public Student(String fullName) {
		this.fullName = fullName;
	}

	public Student(String id, String fullName, Double mediumScore) {
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

	public Double getMediumScore() {
		return mediumScore;
	}

	public void setMediumScore(Double mediumScore) {
		this.mediumScore = mediumScore;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof Student)) {
			return false;
		}
		Student s = (Student) o;
		return s.getId().equals(getId());
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}

	@Override
	public String toString() {

		return id + "-" + fullName + "-" + mediumScore;
	}

}
