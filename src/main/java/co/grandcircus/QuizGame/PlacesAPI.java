package co.grandcircus.QuizGame;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.QuizGame.placesEntities.Candidate;
import co.grandcircus.QuizGame.placesEntities.Places;
import co.grandcircus.QuizGame.placesEntities.Result;

@Component
public class PlacesAPI {


		private RestTemplate rt;
//
		// initialization block that runs when a new instance of the class is created
		// loaded before the constructor
		{
			ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
				request.getHeaders().add(HttpHeaders.USER_AGENT, "ooeeee!");
				return execution.execute(request, body);
			};
			rt = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
		}

	

	@Value("${placesKey}")
	private String placesKey;

	public List<Result> getPlaces() { 

		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=42.3293,-83.0398&radius=1500&type=restaurant&key="+placesKey;
		
		Places response = rt.getForObject(url, Places.class);
		
		List<Result> candidates = response.getResults();
		

		return candidates;
	}
	
}