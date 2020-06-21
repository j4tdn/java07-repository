package date02;

import java.util.Objects;

import date01.Student;

public class Dictionary {
	private String word;
	private String mean;
	private String type;
	private String note;

	public Dictionary() {
	}

	public Dictionary(String mean, String type, String note) {
		this.mean = mean;
		this.type = type;
		this.note = note;
	}

	public Dictionary(String word, String mean, String type, String note) {
		this.word = word;
		this.mean = mean;
		this.type = type;
		this.note = note;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		return Objects.hash(word);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof Dictionary)) {
			return false;
		}
		Dictionary s = (Dictionary) o;
		return s.getWord().equals(getWord()) && s.getMean().equals(getMean());
	}

	@Override
	public String toString() {
		return  mean+ " (" + type + ")  " + note;
	}

	public boolean compareTo(String s1, String s2) {

		return s1.equals(s2);
	}
}
