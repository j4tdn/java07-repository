package beans;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -1521788701925647874L;
	private transient String name;
	private transient String phone;
	private transient String city;

	public Customer() {
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
		Customer that = (Customer) o;
		return that.getName().equals(getName()) && that.phone.equals(getPhone()) && that.city.equals(getCity());
	}

	@Override
	public String toString() {
		return String.join(", ", name, phone, city);
	}
}
