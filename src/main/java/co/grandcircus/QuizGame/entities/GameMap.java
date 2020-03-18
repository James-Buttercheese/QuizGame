package co.grandcircus.QuizGame.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class GameMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne (cascade = CascadeType.ALL)
	private Pin startLoc;

	@OneToOne (cascade = CascadeType.ALL)
	private Pin endLoc;

	@ManyToOne (cascade = CascadeType.ALL)
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gameMap")
	private List<Pin> locations;


	

	public GameMap(Pin startLoc, Pin endLoc, User user, List<Pin> locations) {
		super();
		this.startLoc = startLoc;
		this.endLoc = endLoc;
		this.user = user;
		this.locations = locations;
	}



	public GameMap() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pin getStart() {
		return startLoc;
	}

	public void setStart(Pin start) {
		this.startLoc = start;
	}

	public Pin getEnd() {
		return endLoc;
	}

	public void setEnd(Pin end) {
		this.endLoc = end;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Pin> getLocations() {
		return locations;
	}

	public void setLocations(List<Pin> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "Map [id=" + id + ", start=" + startLoc + ", end=" + endLoc + ", user=" + user + ", locations=" + locations
				+ "]";
	}

}
