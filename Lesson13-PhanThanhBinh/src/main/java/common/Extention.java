package common;

public enum Extention {
	//.png, .jpg, .jpeg, .mp3, .mp4, .bat, .java, .txt
	PNG("PNG"),
	JPG("JPG"),
	MP3("MP3"),
	MP4("MP4"),
	BAT("BAT"),
	JAVA("JAVA"),
	TXT("TXT"),
	JPEG("JPEG");
	
	private String value;
	
	Extention(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
