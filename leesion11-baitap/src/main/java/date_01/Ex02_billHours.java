package date_01;

public class Ex02_billHours extends Ex02_hotel {

	private int hoursBill;

	public int getHoursBill() {
		return hoursBill;
	}

	public void setHoursBill(int hoursBill) {
		this.hoursBill = hoursBill;
	}

	public Ex02_billHours(int idbill, String dateBill, String nameCustomer, double unitprice,int hoursBill) {
		super(idbill,dateBill,nameCustomer,unitprice);
		this.hoursBill = hoursBill;
	}

	@Override
	public String toString() {
		return "id: " +idbill+ "date: " + dateBill +" name: "+nameCustomer +" Gia: " +unitprice + "billHours" + hoursBill;

	}
	public Double moneyInto() {
		double sum = 0;
		if(getHoursBill() > 24 && getHoursBill() < 30) {
			sum = 24 * getUnitprice();
		}else {
			sum = getHoursBill() * getUnitprice();
		}
		return sum;
	}
	
}
