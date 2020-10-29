package DTO;

public class ItemGroupDetailRawData {
	private Integer id;
	private String name;
	private Integer amountOfItems;
	private String detail;

	public ItemGroupDetailRawData() {
	}

	public ItemGroupDetailRawData(Integer id, String name, Integer amountOfItems,String detail) {
		this.id =  id;
		this.name = name;
		this.amountOfItems  = amountOfItems;
		this.detail = detail;
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

	public Integer getAmountOfItems() {
		return amountOfItems;
	}

	public void setAmountOfItems(Integer amountOfItems) {
		this.amountOfItems = amountOfItems;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountOfItems == null) ? 0 : amountOfItems.hashCode());
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemGroupDetailRawData other = (ItemGroupDetailRawData) obj;
		if (amountOfItems == null) {
			if (other.amountOfItems != null)
				return false;
		} else if (!amountOfItems.equals(other.amountOfItems))
			return false;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", amountOfItems=" + amountOfItems + ", detail=" + detail + "]";
	}

}
