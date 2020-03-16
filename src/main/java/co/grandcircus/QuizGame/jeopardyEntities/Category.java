package co.grandcircus.QuizGame.jeopardyEntities;

//import java.util.List;

public class Category {

	private Long id;
	private String title;
	private String created_at;
	private String updated_at;
	private Integer clues_count;
//	private List<Clue> clues; 
//	
//	public List<Clue> getClues() { 
//		return clues;
//	}
//	public void setClues(List<Clue> clues) { 
//		this.clues = clues;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Integer getClues_count() {
		return clues_count;
	}
	public void setClues_count(Integer clues_count) {
		this.clues_count = clues_count;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", clues_count=" + clues_count + "]";
	}
	
}
