package co.grandcircus.QuizGame.placesEntities;

public class Photo {
	
	private Long height;
	private Long width;
	private String photo_reference;
	@Override
	public String toString() {
		return "Photo [height=" + height + ", width=" + width + ", photo_reference=" + photo_reference + "]";
	}
	public Long getHeight() {
		return height;
	}
	public void setHeight(Long height) {
		this.height = height;
	}
	public Long getWidth() {
		return width;
	}
	public void setWidth(Long width) {
		this.width = width;
	}
	public String getPhoto_reference() {
		return photo_reference;
	}
	public void setPhoto_reference(String photo_reference) {
		this.photo_reference = photo_reference;
	}

}
