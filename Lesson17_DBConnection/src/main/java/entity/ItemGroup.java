package entity;

import java.util.Objects;

public class ItemGroup {
	private Integer id;
	private String name;

	public ItemGroup() {
	}

	public ItemGroup(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemGroup)) {
			return false;
		}

		ItemGroup that = (ItemGroup) obj;
		return getId().equals(that.getId()) && getName().equals(that.getName());
	}

	@Override
	public String toString() {
		return "[" + id + "]" + " - " + "[" + name + "]";
	}
}