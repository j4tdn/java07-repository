package beans;

import java.util.Objects;

public class Trader {
	private String name;
	private String city;
	
	public Trader() {
		super();
	}

	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, city);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Trader) ) {
			return false;
		}
		Trader t = (Trader) obj;
		return t.getName() == getName() && t.getCity().equals(getCity());
	}

	@Override
	public String toString() {
		return name + " " + city;
	}
	
}
