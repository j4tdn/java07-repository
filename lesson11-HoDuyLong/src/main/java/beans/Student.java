package beans;

public class Student {
	private String id;
	private String fullname;
	private float gpa;

	public Student() {

	}

	public Student(String id, String fullname, float gpa) {
		this.id = id;
		this.fullname = fullname;
		this.gpa = gpa;
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

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Student)) {
			return false;
		}
		Student that = (Student) obj;
		return this.getId() == that.getId();
	}

	@Override
	public String toString() {
		return id + ", " + fullname + ", " + gpa;
	}
}
