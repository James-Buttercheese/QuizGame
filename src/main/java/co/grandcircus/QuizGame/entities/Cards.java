package co.grandcircus.QuizGame.entities;

import java.io.Serializable;
import java.util.List;

public class Cards implements Serializable{

	private final static long serialVersionUID=1L;
	
	private List<Card> catCards;
	private List<String> catCardsNames;

	public List<Card> getCatCards() {
		return catCards;
	}

	public void setCatCards(List<Card> catCards) {
		this.catCards = catCards;
	}
	
	public void addCard(Card card) {
		this.catCards.add(card);
	}
	
	public void addCardName(String name) {
		this.catCardsNames.add(name);
	}

	public List<String> getCatCardsNames() {
		return catCardsNames;
	}

	public void setCatCardsNames(List<String> catCardsNames) {
		this.catCardsNames = catCardsNames;
	}

	@Override
	public String toString() {
		return "Cards [catCards=" + catCards + "]";
	}
	
	
	
	
	
	
}
