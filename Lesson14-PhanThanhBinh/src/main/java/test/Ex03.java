package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.sound.sampled.ReverbType;

public class Ex03 {
	public static void main(String[] args) {
		String first = "Word";
		String second = "droW";
		System.out.println(anagram(first, second));
	}

	private static boolean anagram(String first, String second) {
		List<String> firsts = getChar(first);
		List<String> seconds = getChar(second);
		
		firsts.sort((s1, s2) -> s1.compareTo(s2));
		seconds.sort((s1, s2) -> s1.compareTo(s2));
		
		if (firsts.size() != seconds.size()) {
			return false;
		} else {
			for (int i = 0; i < firsts.size(); i++) {
				if (!firsts.get(i).equals(seconds.get(i))) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static List<String> getChar(String str) {
		String[] chars = str.trim().split("");
		List<String> rs = new ArrayList<>();
		for (String c : chars) {
			if (!c.matches("\\s+")) {
				rs.add(c.toLowerCase());
			}
		}
		return rs;
	}
	
	
}
