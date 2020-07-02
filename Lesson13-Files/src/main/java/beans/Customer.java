package beans;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
	private static final long serialVersionUID = -1521788701925647874L;

	private String name;
	private String phone;
	private String city;

	public Customer() {
		// TODO Auto-generated constructor stub
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer c = (Customer) obj;
		return c.getName().equals(getName()) && c.getPhone().equals(getPhone()) && c.getCity().equals(getCity());
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, phone, city);
	}

	@Override
	public String toString() {
		return String.join(", ", name, phone, city);
	}
}