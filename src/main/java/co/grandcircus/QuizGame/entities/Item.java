package co.grandcircus.QuizGame.entities;

import javax.persistence.*;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cardName;    //maybe not but we'll see
	private String cardActualName;
//	private String status;

	@ManyToOne (cascade = CascadeType.ALL)
	private User user;
//	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCard(String cardName) {
		this.cardName = cardName;
	}

//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public String getCardActualName() {
		return cardActualName;
	}

	public void setCardActualName(String cardActualName) {
		this.cardActualName = cardActualName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", cardName=" + cardName + ", user=" + user + "]";
	}

	

}
