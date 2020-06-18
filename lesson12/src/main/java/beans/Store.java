package beans;

import java.util.Objects;

public class Store {
private String id;
private String name;
private String address;


public Store() {
	// TODO Auto-generated constructor stub
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
public int hashCode() {
	return Objects.hash(id, name, address);
}

public boolean equals(Object o) {// luc runtime sẽ sai vì nó ko gọi hàm này nên phải sửa thành object

	if (this == o) {
		return true;
	}
	if (o == null || o instanceof Store) {
		return false;
	}
	Store a = (Store) o;
	return a.getId().equals(getId())&&a.getName().equals(getName())&&a.getAddress().equals(getAddress());
}

}
