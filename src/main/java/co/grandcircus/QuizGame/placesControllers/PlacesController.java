package co.grandcircus.QuizGame.placesControllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.PlacesAPI;
import co.grandcircus.QuizGame.entities.GameMap;
import co.grandcircus.QuizGame.entities.Pin;
import co.grandcircus.QuizGame.placesEntities.Location;
import co.grandcircus.QuizGame.placesEntities.Result;
import co.grandcircus.QuizGame.repositories.MapRepository;

@Controller
public class PlacesController {

	@Autowired
	private HttpSession sesh;

	@Autowired
	private MapRepository mapdao;

	@Autowired
	private PlacesAPI placesApi;

	@RequestMapping("/places")
	public ModelAndView places(@RequestParam(name = "lat", required = false) Double lat,
			@RequestParam(name = "lng", required = false) Double lng,
			@RequestParam(name = "locale", required = false) String locale) {

		List<Result> candidates = placesApi.getDetroit();

		ModelAndView mav = new ModelAndView("placesTest");
		mav.addObject("candidates", candidates);

		if (lat != null && lng != null) {

			mav.addObject("lat", lat);
			mav.addObject("lng", lng);
		} else {
			mav.addObject("lat", 42.3293);
			mav.addObject("lng", -83.0398);
		}

		System.out.println(lat + "" + lng);

		return mav;

	}

	@PostMapping("/places")
	public ModelAndView placesPost(String location) {

		String[] arrOfStr = location.split(",");

		String lat = arrOfStr[0].substring(5);
		String lng = arrOfStr[1].substring(4, arrOfStr[1].length() - 1);

		ModelAndView mav = new ModelAndView("redirect:/places");

		mav.addObject("lat", lat);
		mav.addObject("lng", lng);

		return mav;
	}

	@RequestMapping("/mapping")
	public ModelAndView maps() {

		ModelAndView mav = new ModelAndView("testMaps");

		Location location = new Location(42.3293, -83.0398);
		Location location2 = new Location(42.5, -82.9);
		Location location3 = new Location(42.6, -82.8);
		Location location4 = new Location(42.7, -82.7);
		Location location5 = new Location(42.8, -82.6);
		Location location6 = new Location(42.9, -83.2);
		Location location7 = new Location(43.0, -83.3);

		List<Location> locations = new ArrayList<>();

		locations.add(location);
		locations.add(location2);
		locations.add(location3);
		locations.add(location4);
		locations.add(location5);
		locations.add(location6);
		locations.add(location7);
		
		System.out.println(locations);


		mav.addObject("locations", locations);

		return mav;
	}
	
//	@RequestMapping("/mapping")
//	public ModelAndView maps() {
//
//		ModelAndView mav = new ModelAndView("testMaps");
//
//		GameMap map = new GameMap();
//
//		Location location = new Location(42.3293, -83.0398);
//		Location location2 = new Location(42.5, -82.9);
//		Location location3 = new Location(42.6, -82.8);
//		Location location4 = new Location(42.7, -82.7);
//		Location location5 = new Location(42.8, -82.6);
//		Location location6 = new Location(42.9, -83.2);
//		Location location7 = new Location(43.0, -83.3);
//
//		List<Pin> locations = new ArrayList<>();
//
//		locations.add(new Pin(location2.toString(), map));
//		locations.add(new Pin(location3.toString(), map));
//		locations.add(new Pin(location4.toString(), map));
//		locations.add(new Pin(location5.toString(), map));
//		locations.add(new Pin(location6.toString(), map));
//
//		map.setStart(new Pin(location.toString(), map));
//		map.setEnd(new Pin(location7.toString(), map));
//		map.setLocations(locations);
//
//		mapdao.save(map);
//
//		mav.addObject("locations", locations);
//
//		return mav;
//	}

	@RequestMapping("create")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("create");

		return mav;
	}

	@PostMapping("create")
	public ModelAndView createPost(@RequestParam(name="city", required = false)String city,
			@RequestParam(value="locale", required=false) List<String> ids) {
		
		ModelAndView mav = new ModelAndView("create");
		
		if ((city != null) && (!city.isEmpty())) {
		if (city.equalsIgnoreCase("detroit")) {
			List<Result> candidates = placesApi.getDetroit();
			mav.addObject("candidates", candidates);
			System.out.println(candidates);
			
		} else if (city.equalsIgnoreCase("chicago")) {
			List<Result> candidates = placesApi.getChicago();
			mav.addObject("candidates", candidates);
			System.out.println(candidates);
			
		} else if (city.equalsIgnoreCase("newYork")) {
			List<Result> candidates = placesApi.getNewYork();
			mav.addObject("candidates", candidates);
			System.out.println(candidates);
		}
		}
		

		
		if (ids != null) {
			GameMap map = new GameMap();
			List<String> locales= new ArrayList<>();
			List<Result> results = new ArrayList<>();
			List<Pin> locations = new ArrayList<>();
			
			System.out.println(ids);
			
			for(String id : ids) {
			Result result = placesApi.getById(id);
			
			results.add(result);
			locales.add(result.getGeometry().getLocation().toString());
			
			}
			mav.addObject("locations", locales);
			
			map.setStart(new Pin(results.get(0).getGeometry().getLocation().toString(), map));
	
			map.setEnd(new Pin(results.get(results.size()-1).getGeometry().getLocation().toString(), map));
			results.remove(results.size()-1);
			
			for (Result result : results) {
				locations.add(new Pin(result.getGeometry().getLocation().toString(), map));				
			}
			
			map.setLocations(locations);
			mapdao.save(map);
		}
		
		
		return mav;
	}

}
