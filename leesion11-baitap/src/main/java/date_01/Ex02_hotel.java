package date_01;

public class Ex02_hotel {
	private int idbill;
	private String dateBill;
	private String nameCustomer;
	private Double unitprice;
	
	public Ex02_hotel() {
		// TODO Auto-generated constructor stub
	}

	public int getIdbill() {
		return idbill;
	}

	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}

	public String getDateBill() {
		return dateBill;
	}

	public void setDateBill(String dateBill) {
		this.dateBill = dateBill;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Ex02_hotel(int idbill, String dateBill, String nameCustomer, Double unitprice) {
		super();
		this.idbill = idbill;
		this.dateBill = dateBill;
		this.nameCustomer = nameCustomer;
		this.unitprice = unitprice;
	}

	@Override
	public String toString() {
		return "MaHD " + idbill + "Ngay HD " + dateBill + "Ten KH " + nameCustomer
				+ "Don Gia" + unitprice;
	}
	
}
