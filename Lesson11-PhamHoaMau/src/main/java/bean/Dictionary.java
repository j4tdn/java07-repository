package bean;

public class Dictionary {
	private String word;
	private String signification;
	private String type;
	private String noted;

	public Dictionary(String word, String signification, String type, String noted) {
		super();
		this.word = word;
		this.signification = signification;
		this.type = type;
		this.noted = noted;
	}

	@Override
	public String toString() {
		return word + ": " + signification + " <" + type + "> ---" + noted + "----";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else {
			if (getWord().toLowerCase().equals(((String) obj).toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public Dictionary() {
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getSignification() {
		return signification;
	}

	public void setSignification(String signification) {
		this.signification = signification;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNoted() {
		return noted;
	}

	public void setNoted(String noted) {
		this.noted = noted;
	}

}
