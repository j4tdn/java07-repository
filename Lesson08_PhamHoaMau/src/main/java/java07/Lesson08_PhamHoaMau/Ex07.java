package java07.Lesson08_PhamHoaMau;

public class Ex07 {
	static int maxIndex = 0, minIndex = 0;

	public static void main(String[] args) {
		String string = "aaabbbbaaabbaaaaaabbaabbaazzzzzzzzzwwwwwwww";
		int[] indexArray = new int[string.length()];
		int sumIndex = 2;
		for (int i = 1; i < string.length() - 1; i++) {
			if (string.charAt(i) == string.charAt(i + 1)) {
				indexArray[i] = 0;
				sumIndex++;
			} else {
				indexArray[i] = sumIndex;
				sumIndex = 1;
			}
			if (i == string.length() - 2) {
				indexArray[i + 1] = sumIndex;
			}
		}
		System.out.println("Max length of true child string: " + maxValue(indexArray) + " "
				+ string.substring(maxIndex - maxValue(indexArray) + 1, maxIndex + 1) + " ["
				+ (maxIndex - maxValue(indexArray) + 1) + "]");
		System.out.println("Min length of true child string: " + minValue(indexArray) + " "
				+ string.substring(minIndex, minIndex + 1) + " [" + minIndex + "]");
	}

	private static int maxValue(int[] indexArray) {
		int max = indexArray[0];
		for (int i = 1; i < indexArray.length; i++) {
			if (max < indexArray[i]) {
				max = indexArray[i];
				maxIndex = i;
			}
		}
		return max;
	}

	private static int minValue(int[] indexArray) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < indexArray.length; i++) {
			if (indexArray[i] == 0) {
				continue;
			}
			if (min > indexArray[i]) {
				min = indexArray[i];
				minIndex = i;
			}
		}
		return min;
	}
}
