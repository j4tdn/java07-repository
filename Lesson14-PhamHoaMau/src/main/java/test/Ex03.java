package test;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		String input = "Vava";
		String output = "avav";
		System.out.println(anagram(input, output));
	}

	private static boolean anagram(String input, String output) {
		input = input.toLowerCase();
		output = output.toLowerCase();
		if(input.length() != output.length()) {
			return false;
		}
		else {
			char[] inputChar = sortString(input);
			char[] outputChar = sortString(output);
			for (int i = 0; i < outputChar.length; i++) {
				if(inputChar[i] != outputChar[i]) {
					return false;
				}
			}
		}
		return true;
	}

	private static char[] sortString(String input) {
		char[] arr = input.toCharArray(); 
        Arrays.sort(arr); 
        return arr;
	}
}
