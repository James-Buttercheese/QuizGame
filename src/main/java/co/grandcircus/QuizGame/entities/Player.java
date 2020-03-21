package co.grandcircus.QuizGame.entities;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable{
	private final static long serialVersionUID=1L;
	
	private Integer energy;
	private Integer winCount;
	private List<PiD> visited;
	
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

	public void setVisited(List<PiD> visited) {
		this.visited = visited;
	}
	
	public List<PiD> getVisited() {
		return visited;
	}
	@Override
	public String toString() {
		return "{energy:" + energy + ",winCount:" + winCount + ",visited:" + visited + "}";
	}
	
}
