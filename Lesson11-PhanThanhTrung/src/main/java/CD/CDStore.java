package CD;

public class CDStore {
private int id;
private String loaiCD;
private String caSi;
private int soBaiHat;
private int price;

public CDStore() {
	// TODO Auto-generated constructor stub
}


public CDStore(int id, String loaiCD, String caSi, int soBaiHat, int price) {
	super();
	this.id = id;
	this.loaiCD = loaiCD;
	this.caSi = caSi;
	this.soBaiHat = soBaiHat;
	this.price = price;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getLoaiCD() {
	return loaiCD;
}

public void setLoaiCD(String loaiCD) {
	this.loaiCD = loaiCD;
}

public String getCaSi() {
	return caSi;
}

public void setCaSi(String caSi) {
	this.caSi = caSi;
}

public int getSoBaiHat() {
	return soBaiHat;
}

public void setSoBaiHat(int soBaiHat) {
	this.soBaiHat = soBaiHat;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


@Override
public String toString() {
	return "CDStore [id=" + id + ", loaiCD=" + loaiCD + ", caSi=" + caSi + ", soBaiHat=" + soBaiHat + ", price=" + price
			+ "]";
}

}
