package common;

public enum Extension {

	MP3("mp3"),
	MP4("mp4"),
	PNG("png"),
	JPG("jpg"),
	JAVA("java"),
	BAT("bat");
	
	private String value;
	
	Extension(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
