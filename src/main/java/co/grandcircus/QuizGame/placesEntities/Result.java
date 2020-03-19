package co.grandcircus.QuizGame.placesEntities;

import java.util.List;

public class Result {
	
	private Geometry geometry;
	private String name;
	private OpeningHours opening_hours;
	private List <Photo> photos;
	private Double rating;
	private Double prive_level;
	private String vicinity;
	private String place_id;
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
	public Double getPrive_level() {
		return prive_level;
	}
	public void setPrive_level(Double prive_level) {
		this.prive_level = prive_level;
	}
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	@Override
	public String toString() {
		
		this.name = name.replace(" ", "_");
		this.name = name.replace("'", "");
		
		
		return "{rating:" + rating + ",name:"+ "'"+ name + "'" +",place_id:" + "'"+ place_id + "'" + ",lat:" + geometry.getLocation().getLat() + ",lng:" + geometry.getLocation().getLng() + "}";
	}

}
