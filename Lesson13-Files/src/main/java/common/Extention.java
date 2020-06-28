package common;

public enum Extention {
	MP3("mp3"),
	MP4("mp4"), 
	JPG("jpg"),
	PNG("png"),
	JAVA("java"),
	BAT("bat");
	
	private String value;
	
	Extention(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
