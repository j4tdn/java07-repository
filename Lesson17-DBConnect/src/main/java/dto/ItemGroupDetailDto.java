package dto;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

public class ItemGroupDetailDto {
	private Integer id;
	private String name;
	private Integer amountOfItems;
	private List<Pair<String, Integer>> itemList;

	public ItemGroupDetailDto() {
	}

	public ItemGroupDetailDto(ItemGroupDetailRawDto rawData) {
		this.id = rawData.getId();
		this.name = rawData.getName();
		this.amountOfItems = rawData.getAmountOfItems();
		this.itemList = Pattern.compile(", ").splitAsStream(rawData.getDetail()).map(pair -> {
			String[] pairAsString = pair.split(": ");
			return Pair.of(pairAsString[0], Integer.parseInt(pairAsString[1]));
		}).collect(Collectors.toList());
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

	public List<Pair<String, Integer>> getItemList() {
		return itemList;
	}

	public void setItemList(List<Pair<String, Integer>> itemList) {
		this.itemList = itemList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, amountOfItems, itemList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemGroupDetailDto)) {
			return false;
		}
		ItemGroupDetailDto that = (ItemGroupDetailDto) obj;
		return that.getId() == getId() && that.getName().equals(getName())
				&& that.getAmountOfItems() == getAmountOfItems() && that.getItemList().equals(getItemList());
	}

	@Override
	public String toString() {
		return "id: " + id + ", name: " + name + ", amountOfItems: " + amountOfItems;
	}
}