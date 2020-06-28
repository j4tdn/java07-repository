package beans;

import java.util.Objects;

public class Customer {
	private String name;
	private String phone;
	private String city;

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
	public String toString() {
		return String.join(", ", name, phone, city);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, phone, city);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer that = (Customer) obj;
		return getName().equals(that.getName()) && getPhone().equals(that.getPhone())
				&& getCity().equals(that.getCity());
	}

}
