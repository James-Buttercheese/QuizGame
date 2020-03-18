package co.grandcircus.QuizGame.placesEntities;

import java.util.List;

public class Places {
	
	private List<Candidate> candidates;
	private List<Result> results;
	private Result result;
	private String status;
	
	
	
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
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
	@Override
	public String toString() {
		return "Places [candidates=" + candidates + ", results=" + results + ", result=" + result + ", status=" + status
				+ "]";
	}

}
