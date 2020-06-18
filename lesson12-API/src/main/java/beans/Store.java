package beans;

import java.util.Objects;

public class Store {
	private static String id;
	private static String name;
	private static String address;
	
	public  static String getId() {
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
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	public static Object hashcode() {
		return Objects.hash(id,name,address);
	}
	public boolean equals(Object  o) {
		if(this == o) {
			return true;
		}
		if(o == null || !(o instanceof Store)) {
			return false;
		}
		Store s = (Store)o ;
		return s.getId().equals(s.getId()) 
				&& s.getName().equals(s.getName()) 
				&& s.getAddress() == getAddress(); 
	}	
}
