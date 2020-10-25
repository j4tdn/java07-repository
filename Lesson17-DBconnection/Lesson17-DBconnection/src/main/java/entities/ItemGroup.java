package entities;

public class ItemGroup {
	private Integer id;
	private String name;
	
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

	public ItemGroup() {
	}
	
	private ItemGroup(Integer id, String name) {
		this.id = id;
		this.name = name;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (!(obj instanceof ItemGroup)) {
			return false;
		}
		
		ItemGroup that = (ItemGroup) obj;
				
		return getId().equals(that.getId()) && getName().equals(that.getName());
		}
	
	
}
