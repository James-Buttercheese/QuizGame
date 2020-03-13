package co.grandcircus.QuizGame.placesEntities;

public class Geometry {
	
	private Location location;
	private Viewport viewport;
	private String name;
	@Override
	public String toString() {
		return "Geometry [location=" + location + ", viewport=" + viewport + ", name=" + name + "]";
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Viewport getViewport() {
		return viewport;
	}
	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
