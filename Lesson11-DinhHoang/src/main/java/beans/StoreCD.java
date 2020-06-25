package beans;

import java.util.Objects;

public class StoreCD {
	private int id;
	private String species;
	private String singer;
	private int numOfSongs;
	private float price;

	public StoreCD() {
	}

	public StoreCD(int id, String species, String singer, int numOfSongs, float price) {
		this.id = id;
		this.species = species;
		this.singer = singer;
		this.numOfSongs = numOfSongs;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getNumOfSongs() {
		return numOfSongs;
	}

	public void setNumOfSongs(int numOfSongs) {
		this.numOfSongs = numOfSongs;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof StoreCD) {
			return false;
		}
		StoreCD cd = (StoreCD) obj;
		return cd.getId() == getId() && cd.getSpecies().equals(getSpecies()) && cd.getSinger().equals(getSinger())
				&& cd.getNumOfSongs() == getNumOfSongs() && cd.getPrice() == getPrice();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, species, singer, numOfSongs, price);
	}

	@Override
	public String toString() {
		return "- " + id + ", " + species + ", " + singer + ", " + numOfSongs + ", " + price;
	}
}