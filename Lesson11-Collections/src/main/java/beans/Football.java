package beans;

import common.cola;

public class Football {
	private int numberClothes;
	private String fullname;
	private int salary;
	private cola location;

	public Football() {
		// TODO Auto-generated constructor stub
	}

	
	public Football(int numberClothes, String fullname, int salary, cola location) {
		super();
		this.numberClothes = numberClothes;
		this.fullname = fullname;
		this.salary = salary;
		this.location = location;
	}


	public int getNumberClothes() {
		return numberClothes;
	}

	public void setNumberClothes(int numberClothes) {
		this.numberClothes = numberClothes;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public cola getLocation() {
		return location;
	}

	public void setLocation(cola location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return numberClothes + " ," + fullname + " ," + salary + " ," + location;
	}

}
