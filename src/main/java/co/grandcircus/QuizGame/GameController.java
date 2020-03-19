package co.grandcircus.QuizGame;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.entities.GameMap;
import co.grandcircus.QuizGame.placesEntities.Result;
import co.grandcircus.QuizGame.repositories.GameMapRepo;
@Controller
public class GameController {

	@Autowired
	private PlacesAPI papi;

	@Autowired
	private JeopardyAPI japi;
	
	@Autowired
	private GameMapRepo mapdao;
	@Autowired
	private HttpSession sesh;
	
	@RequestMapping("/")
	public ModelAndView mainMenu() {
		sesh.invalidate();
		List<GameMap> maps = mapdao.findAll();
		return new ModelAndView("main-menu", "maps", maps);
	}

	@RequestMapping("/play")
	public ModelAndView places() {
		List<Result> candidates = papi.getDetroit();

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
