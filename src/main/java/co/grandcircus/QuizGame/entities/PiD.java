package co.grandcircus.QuizGame.entities;

import java.io.Serializable;

public class PiD implements Serializable{
	private final static long serialVersionUID=1L;
	
	private String id;

	
	public PiD(String id) {
		super();
		this.id = id;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "{id:'" + id + "'}";
	}
	

}
