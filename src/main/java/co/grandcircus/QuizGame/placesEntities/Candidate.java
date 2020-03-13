package co.grandcircus.QuizGame.placesEntities;

import java.util.List;

public class Candidate {
	
	private String formatted_address;
	private Geometry geometry;
	private String name;
	private OpeningHours opening_hours;
	private List <Photo> photos;
	private Double rating;
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OpeningHours getOpening_hours() {
		return opening_hours;
	}
	public void setOpening_hours(OpeningHours opening_hours) {
		this.opening_hours = opening_hours;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Candidate [formatted_address=" + formatted_address + ", geometry=" + geometry + ", name=" + name
				+ ", opening_hours=" + opening_hours + ", photos=" + photos + ", rating=" + rating + "]";
	}

	
}
