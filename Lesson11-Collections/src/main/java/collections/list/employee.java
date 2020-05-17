package collections.list;

public class employee {
	private String id;
	private String fullname;
	private String title;
	private int age;

	public employee(String id, String fullname, String title, int age) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.title = title;
		this.age = age;
	}
	

	@Override
	public String toString() {
		return "id=" + id + ", fullname=" + fullname + ", title=" + title + ", age=" + age;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
