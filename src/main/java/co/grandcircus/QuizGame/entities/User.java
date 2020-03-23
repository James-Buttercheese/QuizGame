package co.grandcircus.QuizGame.entities;

import java.util.*;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String username;
	private String pin;
	
	@OneToMany(mappedBy="user")
	private List<GameMap> maps;
	
	@OneToMany(mappedBy="user")
	private List<Item> items;

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
		return "User [id=" + id + ", username=" + username + ", pin=" + pin + ", maps=" + maps + ", items=" + items
				+ "]";
	}

	
}
