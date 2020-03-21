package co.grandcircus.QuizGame.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.PlacesAPI;
import co.grandcircus.QuizGame.entities.GameMap;
import co.grandcircus.QuizGame.entities.PiD;
import co.grandcircus.QuizGame.entities.Pin;
import co.grandcircus.QuizGame.entities.Player;
import co.grandcircus.QuizGame.placesEntities.Result;
import co.grandcircus.QuizGame.repositories.GameMapRepo;
import co.grandcircus.QuizGame.repositories.PinRepo;

@Controller
public class PlacesController {

	@Autowired
	private HttpSession sesh;

	@Autowired
	private GameMapRepo mapdao;

	@Autowired
	private PinRepo pindao;

	@Autowired
	private PlacesAPI placesApi;
	
	//private static boolean isBoss;

	
	@RequestMapping("create")
	public ModelAndView create() { //sends you to the create .jsp
		ModelAndView mav = new ModelAndView("create");
		
		List<GameMap> maps = mapdao.findAll();
		mav.addObject("maps", maps);

		return mav;
	}

	@PostMapping("create") //post map for the create jsp, stuff happens
	public ModelAndView createPost(@RequestParam(name = "city", required = false) String city,
			@RequestParam(value = "locale", required = false) List<String> ids,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "mapId", required = false) Long mapId) {

		ModelAndView mav = new ModelAndView("create");

		if ((city != null) && (!city.isEmpty())) { // searches for places based on chosen city
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
			

			GameMap map = new GameMap();
			if (mapId != null) {
				map = mapdao.findById(mapId).orElse(null);
				pindao.deleteByGameMapId(mapId);
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
			mav.addObject("locations", locales);

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
			if (!name.isEmpty()) {
			map.setName(name);
			}
			mapdao.save(map); //saves to db

			mav.addObject("results", strings);

		}
		
		if (mapId != null) {
			
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

		return mav;
	}

	@RequestMapping("play-map") //generates the map that the player will use to play the game
	public ModelAndView play(@RequestParam(name = "mapId") Long id,
			@SessionAttribute(name = "player", required = false) Player player) {
		ModelAndView mav = new ModelAndView("play-map");

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

		return mav;
	}
	
	@RequestMapping("boss") 
	public ModelAndView boss() {
		return new ModelAndView("boss");
	}

}
