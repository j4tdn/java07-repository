package declaration_allcation;

public class Ex01 {

	public static void main(String[] args) {
		// primitive
		// object
		// + String, Integer
		// + Manual object

		int[] firstNumbers = new int[3];
		firstNumbers[1] = 99;
		System.out.println(firstNumbers[0] + "-" + firstNumbers[1] + "-" + firstNumbers[2]);
		
		
		//second way
		int[] secondNumbers = {11,22,0};
		System.out.println(secondNumbers[0] + "-" + secondNumbers[1] + "-" + secondNumbers[2]);
	}

}
