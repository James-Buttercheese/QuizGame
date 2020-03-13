package co.grandcircus.QuizGame.placesEntities;

import java.util.List;

public class Places {
	
	private List<Candidate> candidates;
	private String status;
	
	@Override
	public String toString() {
		return "Places [candidates=" + candidates + ", status=" + status + "]";
	}
	public List<Candidate> getCandidates() {
		return candidates;
	}
	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
