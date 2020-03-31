package exercise;

public class Ex02 {
	private static final int fisrtChar = 0;
	public static void main(String[] args) {
		String name = "aDam   jonh soN";	
		System.out.println(standardName(name));
	}
	
	private static String standardName(String name) {
		String[] words = name.split("[\\s]+");
		
		for (int i = 0; i < words.length; i++) {
			String charToUpperCase = words[i].substring(0, 1).toUpperCase();
			String charToLowperCase = words[i].substring(1).toLowerCase();
			words[i] = charToUpperCase + charToLowperCase;
		}
		return String.join(" ", words);
	}
}
