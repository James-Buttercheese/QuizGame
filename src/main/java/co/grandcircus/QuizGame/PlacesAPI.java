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

@Component
public class PlacesAPI {


		private RestTemplate rt;

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

	public List<Candidate> getPlaces() { 

		String url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=Museum%20of%20Contemporary%20Art%20Australia&inputtype=textquery&fields=photos,formatted_address,name,rating,opening_hours,geometry&key=AIzaSyAQBAPP61snKjU7C8Gma0DXzZ_YkJ9wsLk";

		Places response = rt.getForObject(url, Places.class);
		
		System.out.println(response);
		
		List<Candidate> candidates = response.getCandidates();

		return candidates;
	}
}