package dto;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;




public class ItemGroupDetailDto {
	private Integer id;
	private String name;
	private Integer amountOfItem;
	private List<Pair<String, Integer>> itemList;

	public ItemGroupDetailDto() {
		
	}

	public ItemGroupDetailDto(ItemGroupDetailRawData rawData) {
		this.id = rawData.getId();
		this.name = rawData.getName();
		this.amountOfItem = rawData.getAmountOfItem();
		this.itemList = Pattern.compile("-").splitAsStream(rawData.getDetail()).map(pair ->{
			String[] pairAsString = pair.split(":");
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

	public Integer getAmountOfItem() {
		return amountOfItem;
	}

	public void setAmountOfItem(Integer amountOfItem) {
		this.amountOfItem = amountOfItem;
	}

	public List<Pair<String, Integer>> getDetail() {
		return itemList;
	}

	public void setDetail(List<Pair<String, Integer>> detail) {
		this.itemList = detail;
	}

	@Override
	public String toString() {
		return " id=" + id + ", name=" + name + ", amountOfItem=" + amountOfItem;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id, name, amountOfItem);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ItemGroupDetailDto)) {
			return false;
		}
		ItemGroupDetailDto that = (ItemGroupDetailDto) o;
		return getId().equals(that.getId()) && getName().equals(that.getName())
				&& getAmountOfItem().equals(that.getAmountOfItem());
	}

}
