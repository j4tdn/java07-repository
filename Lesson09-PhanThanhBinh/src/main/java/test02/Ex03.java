package test02;

public class Ex03 {
	public static void main(String[] args) {
		String registers = "102-Nam-C, 104-Hoàng-D, 109-Lan-A, 103-Bảo-F, 105-Nguyên-B, 107-Vũ-F, 103-Bảo-F, 202-Đạt-C, 107-Vũ-C, 193-Bảo-B, 199-Tài-A";
		System.out.print("Register one time: ");
		showArr(getRegisterOneTime(registers));
		System.out.println();
		getRegisterRankA(registers);
	}
	
	private static String[] getRegisterOneTime(String registers) {
		String[] registerArr = registers.split(", ");
		String[] registersOneTime = new String[registerArr.length]; 
		int index = 0;
		for (int i = 0; i < registerArr.length - 1; i++) {
			int count = 0;
			String id = registerArr[i].split("-")[0];
			for (int j = i + 1; j < registerArr.length; j++) {
				String id1 = registerArr[j].split("-")[0];
				if (id.equals(id1)) {
					count++;
				}
			}
			if (count == 0) {
				registersOneTime[index] = registerArr[i];
				index++;
			}
		}
		
		return registersOneTime;
	}
	
	private static void getRegisterRankA(String registers) {
		System.out.print("Register one time and rank A: ");
		String[] registerOneTimes = getRegisterOneTime(registers);
		for (String item: registerOneTimes) {
			if (item != null) {
				if (item.split("-")[2].equals("A")) {
					System.out.println(item + " ");
				}
			}
		}
	}
	
	private static void showArr(String[] arr) {
		for (String item: arr) {
			if (item != null) {
				System.out.print(item + " ");
			}
		}
	}
}
