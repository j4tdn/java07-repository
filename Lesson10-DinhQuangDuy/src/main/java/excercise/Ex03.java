package excercise;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		String[] strings = { "-1", "-6", "10", "4", "Special", "a", "b", "xx" };
		sortString(strings, Sort.ASC);
		System.out.println("=============tang dang==============");
		Arrays.stream(strings).forEach(string -> System.out.print(string + "  "));
		
		System.out.println("\n=============giam dang==============");
		sortString(strings, Sort.DESC);
		Arrays.stream(strings).forEach(string -> System.out.print(string + "  "));
		
	}

	private static void sortString(String[] strings, Sort sort) {
		for (int out = 0; out < strings.length; out++) {
			if ("Special".equals(strings[out])) {
				continue;
			}
			for (int in = strings.length - 1; in > out; in--) {
				if ("Special".equals(strings[in])) {					
					swapString(strings,in,out);
					break;
				}
				if(isDigit(strings[out]) && isDigit(strings[in])) {
					if(Integer.parseInt(strings[out]) > Integer.parseInt(strings[in])) {					
						swapString(strings,in,out);
						break;
					}
				}if (strings[out].compareTo(strings[in]) > 0) {
					swapString(strings,in,out);
					break;
				}
				
			}
		}
		
		if(Sort.DESC.equals(sort)) {
			reversed(strings);
		}
		
	}
	
	private static void reversed(String[] strings) {
		for(int i = 0; i < strings.length / 2; i++) {
			String tmp = strings[i];
			strings[i] = strings[strings.length - i -1];
			strings[strings.length - i -1] = tmp;
		}
		
	}

	private static void swapString(String[] strings, int in, int out) {
		String tmp = strings[out];
		strings[out] = strings[in];
		strings[in] = tmp;
	}
	
	private static boolean isDigit(String string) {
		try {
			int number = Integer.parseInt(string);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
}
enum Sort{
	ASC, DESC
}