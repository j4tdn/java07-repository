package bt2;

import java.util.Comparator;
import java.util.Objects;

public class Dictionary {
	private String words;
	private String means;
	private String wordType;
	private String note;

	public Dictionary() {
		// TODO Auto-generated constructor stub
	}

	public Dictionary(String words, String means, String wordType, String note) {
		super();
		this.words = words;
		this.means = means;
		this.wordType = wordType;
		this.note = note;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getMeans() {
		return means;
	}

	public void setMeans(String means) {
		this.means = means;
	}

	public String getWordType() {
		return wordType;
	}

	public void setWordType(String wordType) {
		this.wordType = wordType;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "words :" + words + " means :" + means + " wordType :" + wordType + " note :" + note;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || obj instanceof Dictionary)
			return false;
		Dictionary d = (Dictionary) obj;
		return d.getWords().equals(getWords()) && d.getMeans().equals(getMeans())
				&& d.getWordType().equals(getWordType()) && d.getNote().equals(getNote());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(words, means, wordType, note);
	}

}
