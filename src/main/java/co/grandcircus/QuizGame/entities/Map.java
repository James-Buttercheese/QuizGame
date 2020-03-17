package co.grandcircus.QuizGame.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Map {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "map")
	private Location startLoc;

	@OneToOne(mappedBy = "map")
	private Location endLoc;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "map")
	private List<Location> locations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Location getStart() {
		return startLoc;
	}

	public void setStart(Location start) {
		this.startLoc = start;
	}

	public Location getEnd() {
		return endLoc;
	}

	public void setEnd(Location end) {
		this.endLoc = end;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "Map [id=" + id + ", start=" + startLoc + ", end=" + endLoc + ", user=" + user + ", locations=" + locations
				+ "]";
	}

}
