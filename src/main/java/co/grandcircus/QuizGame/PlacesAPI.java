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

	public List<Result> getDetroit() { 

		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=42.3293,-83.0398&radius=1500&type=restaurant&key="+placesKey;
		
		Places response = rt.getForObject(url, Places.class);
		
		List<Result> candidates = response.getResults();
		

		return candidates;
	}
	
	public List<Result> getChicago() { 

		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.8827,-87.6233&radius=1500&type=restaurant&key="+placesKey;
		
		Places response = rt.getForObject(url, Places.class);
		
		List<Result> candidates = response.getResults();
		

		return candidates;
	}
	public List<Result> getNewYork() { 

		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=40.7484,-73.9857&radius=1500&type=restaurant&key="+placesKey;
		
		Places response = rt.getForObject(url, Places.class);
		
		List<Result> candidates = response.getResults();
		

		return candidates;
	}
	
	public Result getById(String id) { 

		String url = "https://maps.googleapis.com/maps/api/place/details/json?placeid="+id+"&key="+placesKey;
		Places response = rt.getForObject(url, Places.class);
		
		Result result = response.getResult();
		
		return result;
	}

	public List<Result> getByStart(String id) {
		Result result = getById(id);
		Double lat = result.getGeometry().getLocation().getLat();
		Double lng = result.getGeometry().getLocation().getLng();
		
		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lng+"&radius=1500&type=restaurant&key="+placesKey;
		Places response = rt.getForObject(url, Places.class);
		
		List<Result> candidates = response.getResults();
		
		return candidates;
	}
	
}