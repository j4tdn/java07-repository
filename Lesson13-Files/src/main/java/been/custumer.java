package been;

import java.io.Serializable;
import java.util.Objects;

public class custumer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2015503871873281390L;
	private transient String name;//transient laf 1 tham so.
	private transient String phone;
	private transient String city;

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

	public custumer(String name, String phone, String city) {
		super();
		this.name = name;
		this.phone = phone;
		this.city = city;
	}

	public custumer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.join(" , ", name, phone, city);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return Objects.hash(name, phone, city);
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof custumer)) {
			return false;
		}
		custumer that = (custumer) o;
		return getName().equals(that.getName()) && getPhone().equals(that.getPhone())
				&& getCity().equals(that.getCity());

	}

}
