package common;

public enum Extension {
	TXT(".txt"),
	MP3(".mp3"),
	JPEG(".jpeg"),
	MP4(".mp4"),
	JPG(".jpg"),
	PNG(".png"),
	JAVA(".java"),
	BAT(".bat");
	
	private String value;
	
	Extension(String value) {
		this.value=value;
	}
	public String getValue()
	{
		return this.value;
	}
}
