package BTDATE01;

public class Student {
	private String id;
	private String fullname;
	private int age;
	
	public Student() {
	}

	public Student(String id, String fullname, int age) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return id + ", " + fullname + ", " + age ;
	}
	
}
