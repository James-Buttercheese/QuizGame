package co.grandcircus.QuizGame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.entities.User;
import co.grandcircus.QuizGame.placesEntities.Candidate;
import co.grandcircus.QuizGame.repositories.UserRepository;

@Controller
public class GameController {

	@Autowired
	private PlacesAPI papi;

	@Autowired
	private JeopardyAPI japi;
	
	@Autowired
	private UserRepository urepo;
	
	@RequestMapping("/")
	public ModelAndView mainMenu() {
		ModelAndView mav = new ModelAndView("main-menu");

		return mav;
	}

	@RequestMapping("/play")
	public ModelAndView places() {
		List<Candidate> candidates = papi.getPlaces();

		return new ModelAndView("game-map", "candidates", candidates);
	}

	@RequestMapping("/fight")
	public ModelAndView battleMenu() {
		ModelAndView mav = new ModelAndView("battle");

		return mav;
	}
	@RequestMapping("/{user.username}")
	public ModelAndView userHome(@RequestParam("user.username") String username) {
		
		return null;
	}
}
