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
	
	public Clue[] findByCategory(Integer id){ 
		
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
		
		String url = "http://jservice.io/api/clues?value=" + difficulty + "&offset=" + offset;
		Clue[] clue = rt.getForObject(url, Clue[].class);
		return clue;
	
	}
	
	
	public Clue[] findByCategoryAndDifficulty(Integer difficulty, Integer id) {
		
		String url = "http://jservice.io/api/clues?value=" + difficulty + "&category=" + id;
		Clue[] clue = rt.getForObject(url, Clue[].class);
		return clue;
		
	}
	
	
	public Integer generateRandomOffsetByDifficulty(Integer difficulty) {
		
		// Difficulty: 100 - 1000 both inclusive (not 700, not 900)
				// Offset: from 0 to (incrementing by 100)
				// 100 - 9700 (45 clues)
				// 200 - 30900 (4 clues)
				// 300 - 9200 (84 clues)
				// 400 - 29900 (55 clues)
				// 500 - 8800 (73 clues)
				// 600 - 20300 (12 clues)
				// 800 - 19800 (9 clues)
				// 1000 - 19800 (37 clues)
		int maxOffset = 0;
		
		switch(difficulty) {
		case 100:
			maxOffset = 9700;
			break;
		case 200:
			maxOffset = 30900;
			break;
		case 300:
			maxOffset = 9200;
			break;
		case 400:
			maxOffset = 29900;
			break;
		case 500:
			maxOffset = 8800;
			break;
		case 600:
			maxOffset = 20300;
			break;
		case 800:
		case 1000:
			maxOffset = 19800;
			break;
		}
		
		Integer randomOffset = (int) Math.round(Math.random()*maxOffset); //come back
		return randomOffset;	
		
	}
	
	
	public Clue generateRandomClue(Clue[] clues) {
		
		int randomNumber = (int) (Math.random() * clues.length);
		System.out.println(randomNumber);
		
		return clues[randomNumber];
		
	}
	
	
	
	
}
