package exercise;

public enum Extension {
	MP3("mp3"),
	MP4("mp4"),
	JPG("jpg"),
	PNG("png"),
	JAVA("java"),
	BAT("bat"),
	TXT("txt"),
	JPEG("jpeg");
	
	private String value;
	
	Extension(String value) {
		this.value=value;
	}
	public String getValue() {
		return this.value;
	}
}
