package dto;

import java.util.Objects;

public class ItemGroupDetailRawData {
	private Integer id;
	private String name;
	private Integer amountOfItem;
	private String detail;
	
	public ItemGroupDetailRawData() {
		// TODO Auto-generated constructor stub
	}

	public ItemGroupDetailRawData(Integer id, String name, Integer amountOfItem, String detail) {
		super();
		this.id = id;
		this.name = name;
		this.amountOfItem = amountOfItem;
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemGroupDetailRawData)) {
			return false;
		}
		ItemGroupDetailRawData that = (ItemGroupDetailRawData) obj;
		return getId().equals(that.getId()) 
				&& getName().equals(that.getName())
				&& getAmountOfItem().equals(that.getAmountOfItem())
				&& getDetail().equals(that.getDetail());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, amountOfItem, detail);
	}

	@Override
	public String toString() {
		return "ItemGroupDetailDto [id=" + id + ", name=" + name + ", amountOfItem=" + amountOfItem + ", detail="
				+ detail + "]";
	}
	
}
