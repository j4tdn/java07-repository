package ex01;
/*
• In ra các phần tử lẻ trong mảng
• Tính tổng các phần tử chẵn trong mảng
• Gán giá trị cho phần tử đầu tiên = 199
• Tìm phần tử có giá trị lớn nhất trong mảng
• Tìm phần tử có giá trị lớn thứ hai trong mảng
• Sắp xếp mảng theo chiều tăng dần
• Thêm mới phần tử vào vị trí 0, k, n-1
• Xóa phần tử tại vị trí 0, k, n - 1
*/

import java.util.Arrays;

import javax.sound.midi.Soundbank;

public class InSlide10 {
	public static void main(String[] args) {
		int[] numbers = { 11, 33, 77, 66, 22 };

		// in ra các phần tử chẵn trong mảng
		printEvenNumber(numbers);

		// caua 2 tong chan
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			if ((numbers[0] % 2) == 0) {
				sum += numbers[i];
			}
		}
		System.out.println("Tổng chẵn:" + sum);

		numbers[0] = 199;
		// in ra phần tử lớn nhất
		System.out.println("max: " + max(numbers));
		
		//
		sort(numbers);
		Arrays.stream(numbers).forEach(number->System.out.print(number+" "));
		
		System.out.println();
		
		int k=3, value=234;
		numbers=insertK(numbers,k,value);
		Arrays.stream(numbers).forEach(number->System.out.print(number+" "));
		
		
		
	}
	// 22 33 66 77 199
	// value=234 , k=3
	private static int[] insertK(int[] numbers, int k, int value) {
		int[] result= new int[numbers.length+1];
		/*
		for (int i = 0; i < k; i++) {
			result[i]=numbers[i];
		}
		result[k]=value;
		for (int i = k; i < numbers.length; i++) {
			result[k+1]=numbers[k];
		}
		*/
		for (int i = 0; i < result.length; i++) {
			if (i<k) {
				result[i]=numbers[i];
			}else if (i==k) {
				result[k]=value;
			}else {
				result[i]=numbers[i-1];
			}
		}
		return result;
	}
	// shift right 1 unit
	private static int[] insertK2(int[] numbers, int k, int value) {
		int[] result= new int[numbers.length+1];
		for (int i = 0; i < numbers.length; i++) {
			result[i]=numbers[i];
		}
		for (int  i = result.length-1;i>k; i++) {
			
		}

		return result;
	}
	

	private static int max(int[] numbers) {
		int max = numbers[0];
		for (int i : numbers) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	private static int secondMax(int[] numbers) {
		int max = (numbers[0] > numbers[1]) ? numbers[0] : numbers[1];
		int secondMax = (numbers[0] < numbers[1]) ? numbers[0] : numbers[1];

		for (int number : numbers) {
			if (number > max) {
				secondMax = max;
				max = number;
			} else if (number != max && number > secondMax) {
				secondMax = number;
			}
		}
		return secondMax;
	}

	private static int[] printEvenNumber(int[] numbers) {
		int length = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				length++;
			}
		}

		int[] evenNumbers = new int[length];
		int index = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				evenNumbers[index++] = number;
				System.out.println(number);
			}
		}
		return evenNumbers;
	}
	// bubble sort
	private static void sort(int[] numbers) {
		for (int out= numbers.length-1; out>0;out--) {
			for(int in=0;in<=out;in++) {
				if (numbers[in]>numbers[out]) {
					int temp= numbers[in];
					numbers[in]=numbers[out];
					numbers[out]=temp;
				}
			}
		}
	}
	
}
