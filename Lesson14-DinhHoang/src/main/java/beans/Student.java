package beans;

public class Student {
	private String id;
	private String name;
	private float score;
	private String sex;

	public Student() {
	}

	public Student(String id, String name, float score, String sex) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String isSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + score + ", " + sex;
	}
}