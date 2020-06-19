package beans;

public class Dictionary {
	private String word;
	private String definition;
	private String type;
	private String note;

	public Dictionary() {

	}

	public Dictionary(String word, String definition, String type, String note) {
		this.word = word;
		this.definition = definition;
		this.type = type;
		this.note = note;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Dictionary)) {
			return false;
		}
		Dictionary that = (Dictionary) obj;
		return that.getWord().toLowerCase().equals(getDefinition().toLowerCase());
	}

	@Override
	public String toString() {
		return word + ", " + definition + ", " + type + ", " + note;
	}
}
