package exercise;

public class Ex07 {
	public static void main(String[] args) {
		String str = new String("aaabbaaaab");
		getSameString(str);
	}

	private static void getSameString(String str) {
		int count = 2; // độ dài của mảng chứa các index tại vị trí cắt. bắt đầu từ 2 vì sẽ có vị trí 0
						// và vị trí length
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {
				count++;
			}
		}

		int[] indexCut = new int[count];
		StringSame[] strSames = new StringSame[count - 1];
		indexCut[0] = 0;
		indexCut[count - 1] = str.length();
		int index = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {
				indexCut[index] = i + 1;
				index++;
			}
		}
		
		for (int i = 0; i < indexCut.length - 1; i++) {
			strSames[i] = new StringSame(str.substring(indexCut[i], indexCut[i + 1]), indexCut[i]);
		}

		StringSame strMax = strSames[0];
		StringSame strMin = strSames[0];

		for (StringSame item : strSames) {
			strMax = strMax.getStr().length() > item.getStr().length() ? strMax : item;
			strMin = strMin.getStr().length() < item.getStr().length() ? strMin : item;
		}

		System.out.println(strMax.getStr().length() + " " + strMax.getStr() + " [" + strMax.getStart() + "]");
		System.out.println(strMin.getStr().length() + " " + strMin.getStr() + " [" + strMin.getStart() + "]");
	}
}

class StringSame {
	private String str;
	private int start;

	public StringSame(String str, int start) {
		super();
		this.str = str;
		this.start = start;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
}
