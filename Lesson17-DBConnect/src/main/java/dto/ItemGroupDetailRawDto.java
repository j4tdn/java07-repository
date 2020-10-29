package dto;

import java.util.Objects;

public class ItemGroupDetailRawDto {
	private Integer id;
	private String name;
	private Integer amountOfItems;
	private String detail;

	public ItemGroupDetailRawDto() {
	}

	public ItemGroupDetailRawDto(Integer id, String name, Integer amountOfItems, String detail) {
		this.id = id;
		this.name = name;
		this.amountOfItems = amountOfItems;
		this.detail = detail;
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
		return Objects.hash(id, name, amountOfItems, detail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemGroupDetailRawDto)) {
			return false;
		}
		ItemGroupDetailRawDto that = (ItemGroupDetailRawDto) obj;
		return that.getId() == getId() && that.getName().equals(getName())
				&& that.getAmountOfItems() == getAmountOfItems() && that.getDetail().equals(getDetail());
	}

	@Override
	public String toString() {
		return "id: " + id + ", name: " + name + ", amountOfItems: " + amountOfItems + ", detail: "
				+ detail;
	}
}