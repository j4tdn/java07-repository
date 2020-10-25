package entities;

import java.util.Objects;

public class ItemGroup {
private String name;
private Integer id;


public ItemGroup(Integer id,String name) {
	this.name = name;
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
@Override
public boolean equals(Object o) {
	if(this==o) {
		return true;
	}
	if(!(o instanceof ItemGroup)) {
		return false;
	}
	 ItemGroup that = (ItemGroup) o;
	 return getId().equals(that.getId())&&getName().equals(that.getName());
}
@Override 
public int hashCode() {
	return Objects.hash(id,name);
}

@Override
public String toString() {
	return "name=" + name + ", id=" + id ;
}

}
