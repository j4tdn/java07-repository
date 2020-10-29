package dto;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

public class ItemGroupDetailDTO {
	private Integer id;
	private String name;
	private Integer amountOfItem;
	private List<Pair<String, Integer>> itemList;

	public ItemGroupDetailDTO() {

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

	public List<Pair<String, Integer>> getItemList() {
		return itemList;
	}

	public void setItemList(List<Pair<String, Integer>> itemList) {
		this.itemList = itemList;
	}

	public ItemGroupDetailDTO(ItemGroupDetailRawData rawData) {
		this.id = rawData.getId();
		this.name = rawData.getName();
		this.amountOfItem = rawData.getAmountOfItem();
		this.itemList = Pattern.compile("-")
				.splitAsStream(rawData.getDetail()).
				map(pair -> {
			String[] pairAsString = pair.split(":");
			return Pair.of(pairAsString[0], Integer.parseInt(pairAsString[1]));
		}).collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, amountOfItem);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ItemGroupDetailDTO)) {
			return false;
		}

		ItemGroupDetailDTO that = (ItemGroupDetailDTO) o;

		return getId().equals(that.getId()) && getName().equals(that.getName())
				&& getAmountOfItem().equals(that.getAmountOfItem());
	}

	@Override
	public String toString() {
		return id + "-" + name + "-" + amountOfItem;
	}

}
