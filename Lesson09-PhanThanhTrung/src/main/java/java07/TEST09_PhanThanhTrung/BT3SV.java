package java07.TEST09_PhanThanhTrung;

public class BT3SV {
	public class Sinhvien {
		private int mssv;
		private String fullName;
		private String rank;
		public Sinhvien(){
			
		}
		public Sinhvien(int mssv, String fullName, String rank ) {
			super();
			this.mssv = mssv;
			this.fullName = fullName;
			this.rank = rank;
			
		}
		public int getMssv() {
			return mssv;
		}
		public void setId(int id) {
			this.mssv = mssv;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getPointLT() {
			return rank;
		}
		public void setPointLT(float pointLT) {
			this.rank = rank;

		}
		@Override
		public String toString() {
			return "Sinhvien [id=" + mssv + ", fullName=" + fullName + ", pointLT=" + rank + "]";
		}
}
}