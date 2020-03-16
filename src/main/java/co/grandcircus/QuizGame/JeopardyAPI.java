package co.grandcircus.QuizGame;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.QuizGame.jeopardyEntities.Category;
import co.grandcircus.QuizGame.jeopardyEntities.Clue;

@Component
public class JeopardyAPI {
	
	
	// There's information missing from the API. Empty questions.
	
	private RestTemplate rt;

	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "ooeeee!");
			return execution.execute(request, body);
		};
		rt = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}
	
	public Clue[] findAllClues(Integer offset){	
		
		// There are 156,800 Trivia Questions (Clues)
		// Offsets start at 0 and end at 156800 (both inclusive). Incremented by 100.
		
		if(offset == null) {
			offset = 0;
		}
		
		String url = "http://jservice.io/api/clues?offset=" + offset;
		Clue[] clues = rt.getForObject(url, Clue[].class);
		return clues;

	}
	
	public Category[] findAllCategories(Integer count, Integer offset){	
		
		// There are 18418 categories
		// Offsets start at 0 and end at 18400 (both inclusive). Incremented by 100.
		
		if(count == null) {
			count = 100;
		}
		if (offset == null) {
			offset = 0;
		}
			
		String url = "http://jservice.io/api/categories?count=+ " + count + " &offset= + " + offset;

		Category[] categories = rt.getForObject(url, Category[].class);
		return categories;

	}
	
	
	public Clue[] findRandomClues(Integer count) {
		if (count == null) {
			count = 1;
		}	
		String url = "http://jservice.io/api/random?count=" + count;
		Clue[] clue = rt.getForObject(url, Clue[].class);
		return clue;
	}
	
	public Clue[] findByCategory(Long id){ 
		
		// I believe there aren't any categories with more than 100 clues.
		// But if there are, offset is required
		
		
//		String url = "http://jservice.io/api/category?id=" + id;
//		Category response = rt.getForObject(url, Category.class);
//		return response.getClues();	
		String url = "http://jservice.io/api/clues?category=" + id;
		Clue[] clue = rt.getForObject(url, Clue[].class);
		return clue;
	
	}
	
	public Clue[] findByDifficulty(Integer difficulty, Integer offset){ 
		if (offset == null) {
			offset = 0;
		}	
		
		String url = "http://jservice.io/api/clues?value=" + difficulty;
		Clue[] clue = rt.getForObject(url, Clue[].class);
		return clue;
	
	}

}
