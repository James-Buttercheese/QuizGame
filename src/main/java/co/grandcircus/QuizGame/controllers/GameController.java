package co.grandcircus.QuizGame.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.CatAPI;
import co.grandcircus.QuizGame.JeopardyAPI;
import co.grandcircus.QuizGame.PlacesAPI;
import co.grandcircus.QuizGame.catEntities.CatResponse;
import co.grandcircus.QuizGame.entities.Card;
import co.grandcircus.QuizGame.entities.GameMap;
import co.grandcircus.QuizGame.entities.Item;
import co.grandcircus.QuizGame.entities.User;
import co.grandcircus.QuizGame.repositories.GameMapRepo;
import co.grandcircus.QuizGame.repositories.ItemRepo;
import co.grandcircus.QuizGame.repositories.UserRepo;

@Controller
public class GameController {

	@Autowired
	private PlacesAPI papi;

	@Autowired
	private JeopardyAPI japi;

	@Autowired
	private CatAPI capi;

	@Autowired
	private GameMapRepo mapdao;

	@Autowired
	private HttpSession sesh;

	@Autowired
	private UserRepo userdao;

	@Autowired
	private ItemRepo itemrepo;

	private static boolean isBoss;

	private static List<Item> cardsInDb;

	@RequestMapping("/")
	public ModelAndView mainMenu(@RequestParam(name = "message", required = false) String message) {
		sesh.invalidate();
		isBoss = false;
		List<GameMap> maps = mapdao.findAll();

		ModelAndView mav = new ModelAndView("main-menu");
		mav.addObject("maps", maps);

//		System.out.println(message);

		if (message != null) {
			mav.addObject("message", message);
		}
		return mav;
//		return new ModelAndView("main-menu", "maps", maps);
	}

//	@RequestMapping("/how")
//	public ModelAndView how() {
//		return new ModelAndView("how");
//	}

	@RequestMapping("/bts")
	public ModelAndView bts() {
		return new ModelAndView("bts");
	}

//Added for logging in/signing up; Make user from db Serializable(?)

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(name = "message", required = false) String message) {
		ModelAndView mav = new ModelAndView("login");
		if (message != null) {
			mav.addObject("message", message);
		}
		return mav;
	}

	@PostMapping("/login")
	public ModelAndView loginAuth(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "pin", required = false) String pin,
			@RequestParam(value = "userId", required = false) Long userId) {
		List<User> users = userdao.findAll();

		System.out.println("hello " + userId);
		if (userId == null) {

			for (User user : users) {
				if (user.getUsername().equals(username)) {
					if (user.getPin().equals(pin)) {
						userId = user.getId();
						break;
					}
				}
			}
		}
		if (userId != null) {
			ModelAndView mav = new ModelAndView("main-menu-afterlogin");

//			mav.addObject("username", username);
//			mav.addObject("pin", pin);
			mav.addObject("userId", userId);
			
			System.out.println("hello2");
//			List<Item> cardsInDb = itemrepo.findByUserId(userId);
			cardsInDb = itemrepo.findByUserId(userId);
			
			System.out.println("hello3");

			mav.addObject("cardsInDb", cardsInDb);

			// System.out.println(cardsInDb.size());
			User userr = userdao.findById(userId).orElse(null);
			String usernamee = userr.getUsername();
			mav.addObject("name", usernamee.substring(0, 1).toUpperCase() + usernamee.substring(1));
			mav.addObject("numCards", cardsInDb.size());
			mav.addObject("items", cardsInDb);
			mav.addObject("maps",mapdao.findByUserId(userId));
			mav.addObject("backupMaps", mapdao.findByUserId(3L));
			mav.addObject("userId",userId);

			return mav;
		}

		ModelAndView mav = new ModelAndView("redirect:/login", "message", "Unregistred User | Incorrect information.");
		return mav;

//		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/view-cards")
	public ModelAndView displayCards(@RequestParam("userId") Long userId) {
		System.out.println(cardsInDb);
		List<Card> displayCards = new ArrayList();

		for (Item crd : cardsInDb) {
			CatResponse cr = capi.findBreed(crd.getCardName());
			Card cardd = new Card();
			cardd.setName(cr.getBreeds().get(0).getName());
			cardd.setTemperament(cr.getBreeds().get(0).getTemperament());
			cardd.setDescription(cr.getBreeds().get(0).getDescription());
			cardd.setOrigin(cr.getBreeds().get(0).getOrigin());
			cardd.setUrl(cr.getUrl());
			displayCards.add(cardd);
		}

		ModelAndView mav = new ModelAndView("displayCards");
//		mav.addObject("username", username);
//		mav.addObject("pin", pin);
		mav.addObject("userId", userId);
		mav.addObject("displayCards", displayCards);
		return mav;

//		return new ModelAndView("displayCards", "displayCards", displayCards);
	}

	@RequestMapping("/user-create")
	public ModelAndView signup(@RequestParam(name = "message", required = false) String message) {
		ModelAndView mav = new ModelAndView("createUser");
		if (message != null) {
			mav.addObject("message", message);
		}
		return mav;
	}

	@PostMapping("/user-create")
	public ModelAndView signup(User user, @RequestParam("username") String username) {
		// String message="";
		// User check = userdao.findByUsername(username);

		if (userdao.findByUsername(username) != null) {
			if (username.equals(userdao.findByUsername(username).getUsername())) {
				ModelAndView mav = new ModelAndView("redirect:/user-create");
				mav.addObject("message", "Username exists.");
				return mav;
			}
		} else {
			System.out.println("hello");
			userdao.save(user);
			ModelAndView mav = new ModelAndView("redirect:/login");
			mav.addObject("message", "Successfull registration. Login.");
			return mav;
		}

		return null;
//		return new ModelAndView("redirect:/user-create", "message", message);

//		ModelAndView mav = new ModelAndView("redirect:/");
//		mav.addObject("message", "User added. Please login");
//		return mav;
	}

	@RequestMapping("/leaderboard")
	public ModelAndView leaderboard() {

		List<User> users = userdao.findByOrderByScoreDesc();

		return new ModelAndView("leaderboard", "players", users);
	}

	@RequestMapping("/wins")
	public ModelAndView winsLeaderboard() {

		List<User> users = userdao.findByOrderByWinsDesc();

		return new ModelAndView("leaderboard", "players", users);
	}

	@RequestMapping("/played")
	public ModelAndView playedLeaderboard() {

		List<User> users = userdao.findByOrderByPlayedDesc();

		return new ModelAndView("leaderboard", "players", users);
	}

}
