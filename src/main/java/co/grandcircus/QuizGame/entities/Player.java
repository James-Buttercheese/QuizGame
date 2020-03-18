package co.grandcircus.QuizGame.entities;

import java.io.Serializable;

public class Player implements Serializable{
	private final static long serialVersionUID=1l;
	
	private Integer energy;
	private Integer winCount;
	
	public Integer getEnergy() {
		return energy;
	}
	public void setEnergy(Integer energy) {
		this.energy = energy;
	}
	public Integer getWinCount() {
		return winCount;
	}
	public void setWinCount(Integer winCount) {
		this.winCount = winCount;
	}
	@Override
	public String toString() {
		return "Player [energy=" + energy + ", winCount=" + winCount + "]";
	}
	
}
