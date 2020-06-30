package common;

public enum Garbage {
	IMAGE("image"), MUSIC("music"), SYSTEM("system"), CODING("coding");

	private String value;

	Garbage(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}