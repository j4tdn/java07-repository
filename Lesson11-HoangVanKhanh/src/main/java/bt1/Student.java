package bt1;

public class Student {
	private String id;
	private String name;
	private float average;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String name, float average) {
		super();
		this.id = id;
		this.name = name;
		this.average = average;
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

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", average=" + average;
	}

}
