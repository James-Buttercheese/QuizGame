package co.grandcircus.QuizGame.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.PlacesAPI;
import co.grandcircus.QuizGame.entities.Card;
import co.grandcircus.QuizGame.entities.Cards;
import co.grandcircus.QuizGame.entities.GameMap;
import co.grandcircus.QuizGame.entities.PiD;
import co.grandcircus.QuizGame.entities.Pin;
import co.grandcircus.QuizGame.entities.Player;
import co.grandcircus.QuizGame.entities.User;
import co.grandcircus.QuizGame.placesEntities.Result;
import co.grandcircus.QuizGame.repositories.GameMapRepo;
import co.grandcircus.QuizGame.repositories.PinRepo;
import co.grandcircus.QuizGame.repositories.UserRepo;

@Controller
public class PlacesController {

	@Autowired
	private HttpSession sesh;

	@Autowired
	private GameMapRepo mapdao;

	@Autowired
	private PinRepo pindao;
	
	@Autowired
	private UserRepo userdao;

	@Autowired
	private PlacesAPI placesApi;
	
	@Value("${placesKey}")
	private String placesKey;
	
	
	
	//private static boolean isBoss;

	
	@RequestMapping("create")
	public ModelAndView create(@RequestParam(value="userId", required=false) Long userId,
			@RequestParam(value="mapMessage", required=false) String mapMessage) { //sends you to the create .jsp
		ModelAndView mav = new ModelAndView("create");
//		List<GameMap> maps = mapdao.findAll(); //
		List<GameMap> maps = mapdao.findByUserId(userId); //
		
		
//		System.out.println(mapMessage);
		
		mav.addObject("mapMessage", mapMessage);
		mav.addObject("maps", maps);
		mav.addObject("userId", userId);

		return mav;
	}

	@PostMapping("create") //post map for the create jsp, stuff happens
	public ModelAndView createPost(@RequestParam(name = "city", required = false) String city,
			@RequestParam(value = "locale", required = false) List<String> ids,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "mapId", required = false) Long mapId,
			@RequestParam(value="userId", required=false) Long userId) {

		ModelAndView mav = new ModelAndView("create");
		mav.addObject("userId", userId);
		
//		System.out.println(mapId + " " + userId);

		if ((city != null) && (!city.isEmpty())) { // searches for places based on chosen city
			
			System.out.println("hello1");
			
			if (city.equalsIgnoreCase("detroit")) {
				List<Result> candidates = placesApi.getDetroit();
				mav.addObject("candidates", candidates);

			} else if (city.equalsIgnoreCase("chicago")) {
				List<Result> candidates = placesApi.getChicago();
				mav.addObject("candidates", candidates);

			} else if (city.equalsIgnoreCase("newYork")) {
				List<Result> candidates = placesApi.getNewYork();
				mav.addObject("candidates", candidates);

			}
		}

		if (ids != null) { //takes list of locations chosen by user creates the map,
			//stores it in the db, and sends it to be seen
			System.out.println("hello2");

			GameMap map = new GameMap();
			if (mapId != null) {
				map = mapdao.findById(mapId).orElse(null);
//				pindao.deleteByGameMapId(mapId);
				List <Pin> pins = pindao.findByGameMapId(mapId);
				for (Pin pin : pins) {
					pin.setMap(null);
				}
				
				
			} 
			List<String> locales = new ArrayList<>();
			List<Result> results = new ArrayList<>();
			List<Pin> locations = new ArrayList<>();
			List<String> strings = new ArrayList<>();

			for (String id : ids) {
				Result result = placesApi.getById(id);

				results.add(result);//creates a list of result entities based on ids sent from .jsp
				locales.add(result.getGeometry().getLocation().toString());// creates a list of latlngs for temp map

			}
			if (mapId == null) {
			mav.addObject("locations", locales);
			}

			map.setStart( // sets starting point for map
					new Pin(results.get(0).getGeometry().getLocation().toString(), map, results.get(0).getPlace_id()));

			map.setEnd(new Pin(results.get(results.size() - 1).getGeometry().getLocation().toString(), map,
					results.get(results.size() - 1).getPlace_id()));
			results.remove(results.size() - 1); //sets end point for map

			for (Result result : results) { //stores all middle points for database
				locations.add(new Pin(result.getGeometry().getLocation().toString(), map, result.getPlace_id()));
				strings.add(result.toString());
			}

			map.setLocations(locations);
			
			List<GameMap> mapsInDb = mapdao.findByUserId(userId);
			List<String> mapsNamesInDb = new ArrayList<>();
			for (GameMap gm : mapsInDb) {
				mapsNamesInDb.add(gm.getName());
			}
			
			
			if (!name.isEmpty() && !mapsNamesInDb.contains(name)) {            //
			map.setName(name);
			} else {
				ModelAndView mv = new ModelAndView("redirect:/create");
				mv.addObject("userId", userId);
				mv.addObject("mapMessage","Map name existent or empty.");
				String pkey = placesKey;
				mv.addObject("apikey", pkey);
				return mv;
			}
			
			map.setUser(userdao.findById(userId).orElse(null));
			
			mapdao.save(map);//saves to db

			mav.addObject("results", strings);
		

		}
		
		if (mapId != null  && ids != null) {
			
			List<GameMap> maps = mapdao.findByUserId(userId);
			mav.addObject("maps", maps);
			String pkey = placesKey;
			mav.addObject("apikey", pkey);
			List<String> locales = new ArrayList<>();
			List<Result> results = new ArrayList<>();

			for (String id : ids) {
				Result result = placesApi.getById(id);

				results.add(result);//creates a list of result entities based on ids sent from .jsp
				locales.add(result.getGeometry().getLocation().toString());// creates a list of latlngs for temp map

			}
			mav.addObject("locations", locales);
			
			mav.addObject("mapMessage", "Your map was successfully updated.");
		}
		
		if (mapId != null  && ids == null) {
			
			System.out.println("hello3");
			
			//missing one parameter that's going to take to "another"view
			
			
			List<Pin> locations = pindao.findByGameMapId(mapId);
			List<Result> candidates = placesApi.getByStart(locations.get(0).getPlace_id());
			List<Result> locales = new ArrayList<>();
			
			for (Pin location : locations) {				
				locales.add(placesApi.getById(location.getPlace_id()));
			}
			
			mav.addObject("candidates", candidates);
			mav.addObject("locations", locales);
			mav.addObject("id", mapId);
			
	
		}
		
//		List<GameMap> maps = mapdao.findAll();       //????
		List<GameMap> maps = mapdao.findByUserId(userId);
		mav.addObject("maps", maps);
		String pkey = placesKey;
		mav.addObject("apikey", pkey);

		return mav;
	}

	@RequestMapping("play-map") //generates the map that the player will use to play the game
	public ModelAndView play(@RequestParam(name = "mapId") Long id,
			@RequestParam(name="userId", required=false) Long userId,
			@SessionAttribute(name = "player", required = false) Player player,
			@SessionAttribute(name = "cards", required = false) Cards cards) {
		
		
		ModelAndView mav = new ModelAndView("play-map");
		mav.addObject("userId", userId);
		
		if (userId != null) {
			User user = userdao.findById(userId).orElse(null);
			
			System.out.println("hi");
			System.out.println(userId);
			System.out.println(user);
			
			user.setPlayed(user.getPlayed()+1);
			userdao.save(user);
		}

		if (player == null) { //starts session if one doesn't exist
			List<PiD> visited = new ArrayList<>();
			String startId = pindao.findByGameMapId(id).get(0).getPlace_id();
			visited.add(new PiD(startId));
			Player p = new Player();
			p.setEnergy(15);
			p.setWinCount(0);
			p.setVisited(visited);
			//JeopardyController.isBoss = false;
			sesh.setAttribute("player", p);
			player = (Player) sesh.getAttribute("player");
		}
		
		if (cards == null) {
			List<Card> catCards = new ArrayList<>();
			Cards car = new Cards();
			car.setCatCards(catCards);
			sesh.setAttribute("cards", car);
			
			List<String> catCardsNames = new ArrayList<>(); //??
			car.setCatCardsNames(catCardsNames); //???
			
			
			cards = (Cards) sesh.getAttribute("cards");	
			
			
			//sesh.setAttribute("cardsNames", car);
			//cards = (Cards) sesh.getAttribute("cardsNames");
		}
		
		
		
		List<Pin> pins = pindao.findByGameMapId(id);
		List<String> placeIds = new ArrayList<>();
		List<String> results = new ArrayList<>();
		List<PiD> visited = player.getVisited();
		String start = "";
		String end = "";

		for (Pin pin : pins) { //gets a list of pins from db
			placeIds.add(pin.getPlace_id());
		}
		
		int counter = 0;
		for (String pid : placeIds) { //creates list of mappable results from pin list
			Result result = placesApi.getById(pid);
			results.add(result.toString());
			if (counter == 0) {
				start = result.toString();
			} else if (counter == 1) {
				end = result.toString();
			}
			counter++;
		}
		if (player.getWinCount() == 3) { // if player meets criteria, creates boss situation
			mav.addObject("boss", "Boss");
		}
		mav.addObject("results", results);
		mav.addObject("mid", id);
		mav.addObject("start", start);
		mav.addObject("end", end);
		mav.addObject("visited", visited);
//needed for party list - Jill
		mav.addObject("cats", cards);		
		String pkey = placesKey;
		mav.addObject("apikey", pkey);

		return mav;
	}
	
	@RequestMapping("boss") 
	public ModelAndView boss() {
		return new ModelAndView("boss");
	}

}
