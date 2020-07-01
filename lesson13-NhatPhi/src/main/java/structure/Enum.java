package structure;

public enum Enum {
	PNG("png"),JPG("jpg"),JPEG("jpeg"),MP3("mp3"),MP4("mp4"),BAT("bat"),JAVA("java"),TXT("txt");

	private String value;
	
	Enum(String value) {
		this.value = value;
	}
	public String getValue() {
		return this.value;
	}
}
