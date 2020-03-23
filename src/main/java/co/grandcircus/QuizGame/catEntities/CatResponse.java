package co.grandcircus.QuizGame.catEntities;

import java.util.List;

public class CatResponse {
	
	private List<Breed> breeds;
	private String id;
	private String url;
	private Integer width;
	private Integer height;
	public List<Breed> getBreeds() {
		return breeds;
	}
	public void setBreeds(List<Breed> breeds) {
		this.breeds = breeds;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "CatResponse [breeds=" + breeds + ", id=" + id + ", url=" + url + ", width=" + width + ", height="
				+ height + "]";
	}
	
	

}
