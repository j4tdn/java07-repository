package date_01;

public class Ex02_billdate extends Ex02_hotel {
	private int dateBills; 
	
	public Ex02_billdate() {
	}
	
	public int getDateBills() {
		return dateBills;
	}
	public void setDateBill(int dateBills) {
		this.dateBills = dateBills;
	}
	
	public Ex02_billdate(int idbill, String dateBill, String nameCustomer, double unitprice, int dateBills) {
		super(idbill,dateBill,nameCustomer,unitprice);
		this.dateBills = dateBills;
	}
	
	
	@Override
	public String toString() {
		return "id: " +idbill+ "date: " + dateBill +" name: "+nameCustomer +" Gia: " + unitprice +"DateBill"+dateBills;
	}
	
	public Double moneyInto() {
		double sum = 0;
		if(dateBills <= 7) {
			sum = getDateBills() * getUnitprice();
		}else {
			sum = getDateBills() * getUnitprice() * 0.8;
		}
		return sum;
	}
	
}
