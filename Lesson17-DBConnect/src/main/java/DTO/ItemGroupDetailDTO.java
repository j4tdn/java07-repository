package DTO;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

public class ItemGroupDetailDTO {
	private Integer id;
	private String name;
	private Integer amountOfItems;
	private List<Pair<String, Integer>> itemList;//suwr dungj laij tupble thông qua pair

	public ItemGroupDetailDTO() {
	}

	public ItemGroupDetailDTO(ItemGroupDetailDTO rawData) { 
		this.id =  id;
		this.name = name;
		this.amountOfItems  = amountOfItems;
		this.itemList = Pattern.compile("-").splitAsStream(rawData.getDetail()).map(pair -> {
			String[] pairAsStrings = pair.split(":");
			return Pair.of(pairAsStrings[0], Integer.parseInt(pairAsStrings[1]));
		}).collect(Collectors.toList());
	}

	private CharSequence getDetail() {
		// TODO Auto-generated method stub
		return null;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());
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
		ItemGroupDetailDTO other = (ItemGroupDetailDTO) obj;
		if (amountOfItems == null) {
			if (other.amountOfItems != null)
				return false;
		} else if (!amountOfItems.equals(other.amountOfItems))
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
		return " [id=" + id + ", name=" + name + ", amountOfItems=" + amountOfItems + "]";
	}

	public void setDetail(String string) {
		// TODO Auto-generated method stub
		
	}

}
