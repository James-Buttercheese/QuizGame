package co.grandcircus.QuizGame.placesEntities;

public class OpeningHours {
	
	@Override
	public String toString() {
		return "OpeningHours [open_now=" + open_now + "]";
	}

	public Boolean getOpen_now() {
		return open_now;
	}

	public void setOpen_now(Boolean open_now) {
		this.open_now = open_now;
	}

	private Boolean open_now;

}
