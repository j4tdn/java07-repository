package beans;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1521788701925647874L;
	private transient String name;
	private transient String phone;
	private transient String city;
	public Customer() {
		super();
	}
	public Customer(String name, String phone, String city) {
		super();
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return other.getName().equals(getName()) && other.getPhone().equals(getPhone()) && other.getCity().equals(getCity());
	}
	@Override
	public String toString() {
		return String.join(", ", name, phone, city);
	}
	
}
