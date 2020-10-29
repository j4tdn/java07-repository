package dto;

import java.util.Objects;

import entities.ItemGroup;

public class ItemGroupDetailRawData {
	private Integer id;
	private String name;
	private Integer amountOfItem;
	private String detail;

	public ItemGroupDetailRawData() {

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

	public Integer getAmountOfItem() {
		return amountOfItem;
	}

	public void setAmountOfItem(Integer amountOfItem) {
		this.amountOfItem = amountOfItem;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	public ItemGroupDetailRawData(Integer id, String name, Integer amountOfItem, String detail) {
		this.id = id;
		this.name = name;
		this.amountOfItem = amountOfItem;
		this.detail = detail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, amountOfItem, detail);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ItemGroupDetailRawData)) {
			return false;
		}

		ItemGroupDetailRawData that = (ItemGroupDetailRawData) o;

		return getId().equals(that.getId()) && getName().equals(that.getName())
				&& getAmountOfItem().equals(that.getAmountOfItem()) && getDetail().equals(that.getDetail());
	}

	@Override
	public String toString() {
		return id + "-" + name + "-" + amountOfItem + ",-" + detail;
	}

}
