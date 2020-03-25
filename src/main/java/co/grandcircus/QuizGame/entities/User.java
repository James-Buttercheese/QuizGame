package co.grandcircus.QuizGame.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
	private final static long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String username;
	private String pin;
	
	@OneToMany(mappedBy="user")
	private List<GameMap> maps;
	
	@OneToMany(mappedBy="user")
	private List<Item> items;
	
	private Long score;
	private Long wins;
	private Long played;
	
	
	
	
	

	public User(String username, String pin) {
		super();
		this.username = username;
		this.pin = pin;
	}

	public User() {
		super();
		score = 0L;
		wins = 0L;
		played = 0L;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getWins() {
		return wins;
	}

	public void setWins(Long wins) {
		this.wins = wins;
	}

	public Long getPlayed() {
		return played;
	}

	public void setPlayed(Long played) {
		this.played = played;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", score=" + score + ", wins=" + wins + ", played=" + played + "]";
	}

	
}
