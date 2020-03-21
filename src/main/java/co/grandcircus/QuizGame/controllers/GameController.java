package co.grandcircus.QuizGame.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.JeopardyAPI;
import co.grandcircus.QuizGame.PlacesAPI;
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
	
	private static boolean isBoss;
	
	@RequestMapping("/")
	public ModelAndView mainMenu() {
		sesh.invalidate();
		isBoss = false;
		List<GameMap> maps = mapdao.findAll();
		return new ModelAndView("main-menu", "maps", maps);
	}
	
	
	
//Added for logging in/signing up; Make user from db Serializable(?)
	
	@RequestMapping("/login")
	public ModelAndView login() {
		
		return new ModelAndView("login");
	}
	@PostMapping("/login")
	public ModelAndView loginAuth() {
		
		return null;
	}
	@RequestMapping("/user-create")
	public ModelAndView signup() {
		
		return null;
	}

	
}
