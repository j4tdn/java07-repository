package bean;

public class CD {
	private Integer CDid;
	private String CDType;
	private String singer;
	private Integer numberOfSong;
	private Double price;

	public CD(Integer cDid, String cDType, String singer, Integer numberOfSong, Double price) {
		super();
		CDid = cDid;
		CDType = cDType;
		this.singer = singer;
		this.numberOfSong = numberOfSong;
		this.price = price;
	}

	public CD() {
	}

	@Override
	public String toString() {
		return CDid + "\t" + CDType + "\t" + singer + "\t" + numberOfSong + "\t" + price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null || !(obj instanceof CD)) {
			return false;
		}else {
			if(this.getCDid() == ((CD)obj).getCDid()) {
				return true;
			}
		}
		return false;
	}

	public Integer getCDid() {
		return CDid;
	}

	public void setCDid(Integer cDid) {
		CDid = cDid;
	}

	public String getCDType() {
		return CDType;
	}

	public void setCDType(String cDType) {
		CDType = cDType;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Integer getNumberOfSong() {
		return numberOfSong;
	}

	public void setNumberOfSong(Integer numberOfSong) {
		this.numberOfSong = numberOfSong;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
