package ItemGroupDetailRawData;

import java.util.Objects;

public class ItemGroupRawData {
	private Integer id;
	private String name;
	private Integer amountOfItems;
	private String detail;
	
	public ItemGroupRawData() {
		super();
	}

	public ItemGroupRawData(Integer id, String name, Integer amountOfItems, String detail) {
		super();
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
		
		if (!(obj instanceof ItemGroupRawData)) {
			return false;
		}
		
		ItemGroupRawData that = (ItemGroupRawData) obj;
		return getId().equals(that.getId())
				&& getName().equals(that.getName()) 
				&& getAmountOfItems().equals(that.getAmountOfItems());
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", amountOfItems=" + amountOfItems + ", Detail=" + detail;
	}
	
	
}
