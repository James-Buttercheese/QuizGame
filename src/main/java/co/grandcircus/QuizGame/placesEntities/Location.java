package co.grandcircus.QuizGame.placesEntities;

public class Location {
	
	private Double lat;
	private Double lng;
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return ("{lat:" + lat + ",lng:" + lng + "}");
	}
	public Location(Double lat, Double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	public Location() {
		super();
	}

	
	
}
