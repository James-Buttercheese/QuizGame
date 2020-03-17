package co.grandcircus.QuizGame.entities;

import javax.persistence.*;

@Entity
public class Pin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String latLong;

	@ManyToOne (cascade = CascadeType.ALL)
	private GameMap map;
	
	
	public Pin(String latLong, GameMap map) {
		super();
		this.latLong = latLong;
		this.map = map;
	}



	public Pin() {
		super();
	}



	public Pin(String latLong) {
		super();
		this.latLong = latLong;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLatLong() {
		return latLong;
	}

	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}

	public GameMap getMap() {
		return map;
	}

	public void setMap(GameMap map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", latLong=" + latLong + ", map=" + map.getId() + "]";
	}

}
