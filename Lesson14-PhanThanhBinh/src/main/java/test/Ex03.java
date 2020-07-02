package test;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.ReverbType;

public class Ex03 {
	public static void main(String[] args) {
		String first = "Word";
		String second = "droW";
		String str = "xyz";
		List<String> shuffed = shuffle(str);
		shuffed.forEach(System.out::println);
		System.out.println(anagram(first, second));
	}

	private static boolean anagram(String first, String second) {
		List<String> firsts = getChar(first);
		List<String> seconds = getChar(second);
	
		if (firsts.size() != seconds.size()) {
			return false;
		} else {
			for (int i = 0; i < firsts.size(); i++) {
				if (!firsts.get(i).equals(reseved(seconds).get(i))) {
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
				rs.add(c);
			}
		}
		return rs;
	}
	
	private static List<String> reseved(List<String> list) {
		List<String> rs = new ArrayList<>();
		for (int i = list.size() - 1; i >= 0; i--) {
			rs.add(list.get(i));
		}
		return rs;
	}
	
	private static List<String> shuffle(String str) {
		List<String> rs = new ArrayList<>();
		if (str.length() == 1) {
			rs.add(str);
		} else {
			int lastIndex = str.length() - 1;
			String lastChar = str.substring(lastIndex);
			String firstString = str.substring(0, lastIndex);
			rs = merge(shuffle(firstString), lastChar);
		}
		return rs;
	}

	private static List<String> merge(List<String> list, String lastChar) {
		List<String> rs = new ArrayList<>();
		for (String s: list) {
			for (int i = 0; i < s.length(); i++) {
				String sub = new StringBuffer(s).insert(i, lastChar).toString();
				rs.add(sub);
			}
		}
		return rs;
	}
}
