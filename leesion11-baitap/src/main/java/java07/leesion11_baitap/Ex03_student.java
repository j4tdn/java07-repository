package java07.leesion11_baitap;

public class Ex03_student {
	private Integer idStudent;
	private String nameStudent;
	private Double point;
	public Integer getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}
	public String getNameStudent() {
		return nameStudent;
	}
	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}
	public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
		this.point = point;
	}
	public Ex03_student() {
		// TODO Auto-generated constructor stub
	}
	public Ex03_student(Integer idStudent, String nameStudent, Double point) {
		super();
		this.idStudent = idStudent;
		this.nameStudent = nameStudent;
		this.point = point;
	}
	@Override
	public String toString() {
		return "MSSV " + idStudent + " TenSV " + nameStudent + " DiemTB " + point;
	}
	
	
	
}
