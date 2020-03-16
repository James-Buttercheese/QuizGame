package co.grandcircus.QuizGame.jeopardyEntities;

public class Clue {

	private Long id;
	private String answer;
	private String question;
	private Integer value;
	private String airdate;
	private String created_at;
	private String updated_at;
	private Integer category_id;
	private Integer game_id;
	private Integer invalid_count;
	private Category category;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getAirdate() {
		return airdate;
	}
	public void setAirdate(String airdate) {
		this.airdate = airdate;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getGame_id() {
		return game_id;
	}
	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}
	public Integer getInvalid_count() {
		return invalid_count;
	}
	public void setInvalid_count(Integer invalid_count) {
		this.invalid_count = invalid_count;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Clue [id=" + id + ", question=" + question + ", value=" + value + ", airdate=" + airdate
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", category_id=" + category_id
				+ ", game_id=" + game_id + ", invalid_count=" + invalid_count + ", category=" + category + "]";
	}
	
}

