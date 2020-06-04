
import java.util.Arrays;
import java.util.Random;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = new int[10];
		input(numbers);
		output(numbers);
		System.out.println("\n==========");
		int[] distinct = distinct(numbers);
		output(distinct);
		System.out.println("\n===========");
		compare(numbers);
		System.out.println("\n=============");
		int[] insertSort = insertionSort(numbers);// tạo mảng mới để in ra cho đẹp
		output(insertSort);
		System.out.println("\n=============");
		int result=thirdNumber(numbers);
		System.out.println(result);
	}

	private static void input(int[] numbers) {// tạo ngẫu nhiên 10 phần tử
		Random rd = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rd.nextInt(10) + 1;
		}

	}

	private static void output(int[] numbers) {// in ra
		for (int number : numbers) {

			System.out.print(number + " ");
		}
	}

	private static int[] distinct(int[] numbers) {
		boolean[] flags = new boolean[numbers.length];
		Arrays.fill(flags, true);// gan co cho moi phan tu la true
		int count = 0;
		int[] digits = new int[numbers.length];// tạo 1 mảng mới có số phần tử như numbers
		for (int i = 0; i < flags.length; i++) {// i là index

			if (flags[i] == true) {
				contains(flags, numbers, i);// kiểm tra vẫn bằng true
			}
			if (flags[i] == true) {
				digits[count++] = numbers[i];
			}
		}
		return Arrays.copyOfRange(digits, 0, count);//lấy từ 0 đến count
	}

	private static void contains(boolean[] flags, int[] numbers, int index) {
		for (int i = 0; i < numbers.length; i++) {

			if (numbers[index] == numbers[i] && index != i) {// so sánh vs mảng numbers
				flags[i] = false;
				flags[index] = false;
			} // index là i ở trên
		}
	}

	private static void compare(int[] number) {
		int preSum = 0;
		int posSum = 0;
		for (int i = 0; i < number.length; i++) {
			if (i < 5) {
				preSum += number[i];
			} else {
				posSum += number[i];
			}

		}
		if (preSum == posSum) {
			System.out.println("bằng nhau ok");
		} else if (preSum > posSum) {
			System.out.println("5 phần tử đầu có trung bình lớn hơn");
		} else {
			System.out.println("5 phần tử sau có trung bình lớn hơn");
		}
	}

	private static int[] insertionSort(int[] numbers) {
		int[] insertSort = new int[numbers.length];
		for (int i = 0; i < insertSort.length; i++) {
			insertSort[i] = numbers[i];

		}
		for (int i = 0; i < insertSort.length; i++) {
			for (int j = 0; j < i; j++) {
				if (insertSort[j] > insertSort[i]) {
					int tmp = insertSort[i];
					insertSort[i] = insertSort[j];
					insertSort[j] = tmp;
				}
			}
		}
		return insertSort;
	}

	private static int thirdNumber(int[] numbers) {//kiểm tra từ sau cùng lên đầu
		int[] thirdNumbers = insertionSort(numbers);// khi gọi thì tự new mảng mới
		int count = 0;
		int result = 0;
		for (int i = thirdNumbers.length - 1; i > 0; i--) {
			if (thirdNumbers[i] != thirdNumbers[i - 1]) {
				count++;
				if (count == 2) {
					result = thirdNumbers[i - 1];
					return result;
				}
			}
		}
		System.out.println("deo co");
		return 0;
	}
}
