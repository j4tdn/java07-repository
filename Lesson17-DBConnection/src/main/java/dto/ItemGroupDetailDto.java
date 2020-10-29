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
	private List<Pair<String, Integer>> items;
	
	public ItemGroupDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public ItemGroupDetailDto(ItemGroupDetailRawData rawData) {
		super();
		this.id = rawData.getId();
		this.name = rawData.getName();
		this.amountOfItem = rawData.getAmountOfItem();
		this.items = Pattern.compile("-")
				.splitAsStream(rawData.getDetail())
				.map(pair -> {
					String[] pairAsString = pair.split(":");
					return Pair.of(pairAsString[0], Integer.parseInt(pairAsString[1]));
				})
				.collect(Collectors.toList());
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

	public List<Pair<String, Integer>>  getItems() {
		return items;
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
		return getId().equals(that.getId()) 
				&& getName().equals(that.getName())
				&& getAmountOfItem().equals(that.getAmountOfItem());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, amountOfItem);
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", amountOfItem=" + amountOfItem + "]";
	}
	
}
