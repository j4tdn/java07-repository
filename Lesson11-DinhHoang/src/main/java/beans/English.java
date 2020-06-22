package beans;

import java.util.Objects;

public class English {
	private String word;
	private String means;
	private String wordType;
	private String note;

	public English() {
	}

	public English(String word, String means, String wordType, String note) {
		super();
		this.word = word;
		this.means = means;
		this.wordType = wordType;
		this.note = note;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof English) {
			return false;
		}
		English e = (English) obj;
		return e.getWord().equals(getWord()) && e.getMeans().equals(getMeans()) && e.getWordType().equals(getWordType())
				&& e.getNote().equals(getNote());
	}

	@Override
	public int hashCode() {
		return Objects.hash(word, means, wordType, note);
	}

	@Override
	public String toString() {
		return ">- " + word + " (" + wordType + ") :" + means + " (" + note + ").";
	}
}