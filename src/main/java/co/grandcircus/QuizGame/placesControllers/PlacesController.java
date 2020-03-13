package co.grandcircus.QuizGame.placesControllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.PlacesAPI;
import co.grandcircus.QuizGame.placesEntities.Candidate;

@Controller
public class PlacesController {
	
	@Autowired
	private HttpSession sesh;
	
	@Autowired
	private PlacesAPI placesApi;
	
	@RequestMapping("/places")
	public ModelAndView places() {
		
		List<Candidate> candidates = placesApi.getPlaces();
		
		return new ModelAndView("placesTest", "candidates", candidates);
	}


}
	