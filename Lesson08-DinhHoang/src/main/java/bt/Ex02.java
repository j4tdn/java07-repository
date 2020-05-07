package bt;

public class Ex02 {
	public static void main(String[] args) {
		String s = "aDam Le vAN john Son";
		String newWord = "";
		String[] word = s.split(" ");

		for (int i = 0; i < word.length; i++) {
			word[i] = word[i].substring(0, 1).toUpperCase() + word[i].substring(1).toLowerCase();
			newWord = String.join(" ", newWord, word[i]).trim();
		}
		System.out.println(newWord);
	}
}
