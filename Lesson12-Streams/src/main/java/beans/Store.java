package beans;

import java.util.Objects;

public class Store {
	private String id;
	private String name;
	private String address;
	public Store() {
		super();
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || !(o instanceof Store)) {
			return false;
		}
		
		Store s = (Store) o;
		return s.getId().equals(getId()) && s.getName().equals(getName()) && s.getAddress().equals(getAddress());
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, address);
	}
	@Override
	public String toString() {
		return id + " " + name + " " + address;
	}
	
}
