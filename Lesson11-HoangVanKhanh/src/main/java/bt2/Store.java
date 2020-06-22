package bt2;

import java.util.Objects;

public class Store {
	private int IdCD;
	private String typeCD;
	private String singer;
	private int songsNumber;
	private double price;

	public Store() {
		// TODO Auto-generated constructor stub
	}

	public Store(int idCD, String typeCD, String singer, int songsNumber, double price) {
		super();
		IdCD = idCD;
		this.typeCD = typeCD;
		this.singer = singer;
		this.songsNumber = songsNumber;
		this.price = price;
	}

	public int getIdCD() {
		return IdCD;
	}

	public void setIdCD(int idCD) {
		IdCD = idCD;
	}

	public String getTypeCD() {
		return typeCD;
	}

	public void setTypeCD(String typeCD) {
		this.typeCD = typeCD;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getSongsNumber() {
		return songsNumber;
	}

	public void setSongsNumber(int songsNumber) {
		this.songsNumber = songsNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return +IdCD + " ," + typeCD + " ," + singer + " ," + songsNumber + " ," + price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || o instanceof Store)
			return false;
		Store s = (Store) o;
		return s.getIdCD() == getIdCD() && s.getTypeCD().equals(getTypeCD()) && s.getSinger().equals(getSinger())
				&& s.getSongsNumber() == getSongsNumber() && s.getPrice() == getPrice();
	}

	@Override
	public int hashCode() {

		return Objects.hash(IdCD, typeCD, singer, songsNumber, price);
	}
	

}
