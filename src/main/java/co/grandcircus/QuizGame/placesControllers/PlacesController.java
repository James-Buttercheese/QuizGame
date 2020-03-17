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
import co.grandcircus.QuizGame.placesEntities.Location;
import co.grandcircus.QuizGame.placesEntities.Result;

@Controller
public class PlacesController {

	@Autowired
	private HttpSession sesh;

	@Autowired
	private PlacesAPI placesApi;

	@RequestMapping("/places")
	public ModelAndView places(@RequestParam(name = "lat", required = false) Double lat,
			@RequestParam(name = "lng", required = false) Double lng) {

		List<Result> candidates = placesApi.getPlaces();

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
		String lng = arrOfStr[1].substring(4, arrOfStr[1].length()-1);

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

		mav.addObject("locations", locations);

		return mav;
	}

}
