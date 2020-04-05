package test02;

public class Student {
	private String fullname;
	private String id;
	private String rank;
	
	public Student() {
	}

	public Student(String fullname, String id, String rank) {
		this.fullname = fullname;
		this.id = id;
		this.rank = rank;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	
	
}
