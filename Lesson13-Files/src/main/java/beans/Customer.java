package beans;

import java.util.Objects;

public class Customer {
	private String name;
	private String phone;
	private String city;

	Customer() {
	}

	public Customer(String name, String phone, String city) {
		this.name = name;
		this.phone = phone;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(name, phone, city);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Customer)) {
			return false;
		}
		Customer a = (Customer) o;

		return a.getName().equals(getName()) && a.getPhone().equals(getPhone()) && a.getCity().equals(getCity());

	}

	@Override
	public String toString() {
		return String.join("-",name,phone,city);
	}

}
