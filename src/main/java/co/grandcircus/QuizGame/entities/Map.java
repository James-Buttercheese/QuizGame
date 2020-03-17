package co.grandcircus.QuizGame.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Map {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@Column(name="start_loc")
	private Location start;
	
	@OneToOne
	@Column(name="end_loc")
	private Location end;

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
		return start;
	}

	public void setStart(Location start) {
		this.start = start;
	}

	public Location getEnd() {
		return end;
	}

	public void setEnd(Location end) {
		this.end = end;
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
		return "Map [id=" + id + ", start=" + start + ", end=" + end + ", user=" + user + ", locations=" + locations
				+ "]";
	}

}
