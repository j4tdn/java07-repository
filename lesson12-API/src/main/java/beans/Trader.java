package beans;

public class Trader {
	private String name;
	private String liveCity;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((liveCity == null) ? 0 : liveCity.hashCode());
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
		Trader other = (Trader) obj;
		if (liveCity == null) {
			if (other.liveCity != null)
				return false;
		} else if (!liveCity.equals(other.liveCity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLiveCity() {
		return liveCity;
	}

	public void setLiveCity(String liveCity) {
		this.liveCity = liveCity;
	}

	public Trader(String name, String liveCity) {
		super();
		this.name = name;
		this.liveCity = liveCity;
	}

	@Override
	public String toString() {
		return "Name:  " + name + "City: " + liveCity;
	}
}
