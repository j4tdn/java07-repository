package common;

public enum Image {
	PNG(".png"),JPG(".jpg");
	private String value;

	Image (String value) {
		this.value=value;
	}

	public String getValue() {
		return this.value;
	}
	
	

}
