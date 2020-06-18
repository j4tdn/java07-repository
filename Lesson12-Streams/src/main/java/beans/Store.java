package beans;

import java.util.Objects;

public class Store {
	private String id;
	private String name;
	private String address;
	private Object getId;

	public Store() {
	}

	public Store(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof Apple) {
			return false;
		}
		Store a = (Store) obj;
		return a.getId.equals(getId()) && a.getName().equals(getName()) && a.getAddress().equals(a.getAddress());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, address);
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + address;
	}
}