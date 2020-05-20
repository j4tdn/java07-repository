package exercise;

import java.util.Arrays;

import common.Sort;

public class Bt03 {
	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", "4", "8", "Special", "a", "c", "b", "xx" };

		String[] results = new String[strings.length];
		int[] numbers = new int[strings.length];
		String[] Strings= new String[strings.length];
		int ii = 0;
		int iii =5;
		
		//System.out.println(checkStringIsNumber("afg"));
		for (int i = 0; i < strings.length; i++) {

			if (checkStringIsNumber(strings[i])) {
				//System.out.println(strings[i]);
				//System.out.println(checkStringIsNumber(strings[i]));
				numbers[ii++] = Integer.parseInt(strings[i]);

			} else {
				
				results[iii++] = strings[i];
			}
		}
		for (int i = 0; i < ii; i++) {
			for(int j=ii-1;j>i;j--) {
			if (numbers[i] > numbers[j]) {
				int tmp = numbers[j];
				numbers[j] = numbers[i];
				numbers[i] = tmp;
			}
			}
		}
		System.out.println("");

		Arrays.stream(numbers).forEach(number -> {
			System.out.print(number + " ");
		});
		
		System.out.println();
		String[] results2= new String[results.length-ii];
		int a=results.length-ii;
		for(int i=0;i<results2.length;i++) {
			results2[i]=results[a];
			
			a++;
		}
		sort(results2);
		Arrays.stream(results2).forEach(result -> {
			System.out.print(result + " ");
		});
		Strings[0]=results2[0];
		for(int i=1;i<=ii;i++) {
			Strings[i]=String.valueOf(numbers[i-1]);
		}
		int b=1;
		for(int i=ii+1;i<Strings.length;i++) {
			Strings[i]=results2[b++];
		}
		System.out.println("");
		Arrays.stream(Strings).forEach(String -> {
			System.out.print(String + " ");
			
		});
		System.out.println();
		System.out.println("=========================");
		reversed(Strings);
		
		Arrays.stream(Strings).forEach(String -> {
			System.out.print(String + " ");
			
		});
		
	}

	private static void sorts(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == "Special") {
				continue;
			}
			for (int j = strings.length - 1; j > i; j--) {
				if (strings[j] == "Special") {
					String tmp = strings[j];
					strings[j] = strings[i];
					strings[i] = tmp;
					break;
				}

			}
		}
	}

	private static void sort(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == "Special") {
				continue;
			}
			for (int j = strings.length - 1; j > i; j--) {
				if (strings[j] == "Special") {
					String tmp = strings[j];
					strings[j] = strings[i];
					strings[i] = tmp;
					break;
				}
				int comparision = strings[i].compareTo(strings[j]);
				if (comparision > 0) {
					String tmp = strings[i];
					strings[i] = strings[j];
					strings[j] = tmp;
				}

			}
		}

	}

	private static void reversed(String[] strings) {
		for (int i = 0; i < strings.length / 2; i++) {
			String tmp = strings[i];
			strings[i] = strings[strings.length - i - 1];
			strings[strings.length - i - 1] = tmp;
		}

	}

	private static boolean checkStringIsNumber(String str) {
		if (str.equals('-')) {
			return false;
		}
		if (str.charAt(0) == '-') {
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(i) != '0' && str.charAt(i) != '1' && str.charAt(i) != '2' && str.charAt(i) != '3'
						&& str.charAt(i) != '4' && str.charAt(i) != '5' && str.charAt(i) != '6' && str.charAt(i) != '7'
						&& str.charAt(i) != '8' && str.charAt(i) != '9') {
					return false;
				}
			}
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != '0' && str.charAt(i) != '1' && str.charAt(i) != '2' && str.charAt(i) != '3'
						&& str.charAt(i) != '4' && str.charAt(i) != '5' && str.charAt(i) != '6' && str.charAt(i) != '7'
						&& str.charAt(i) != '8' && str.charAt(i) != '9') {
					return false;
				}
			}
		}
		// System.out.println(str.charAt(0));
		return true;
	}

}
