package co.grandcircus.QuizGame.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.CatAPI;
import co.grandcircus.QuizGame.catEntities.Breed;
import co.grandcircus.QuizGame.catEntities.CatResponse;

@Controller
public class CatController {
	
	@Autowired
	private CatAPI capi;
	
	@RequestMapping("/cat")
	public ModelAndView cats() {
		
		List<CatResponse> images = new ArrayList<>();
		
		List<Integer> powers = new ArrayList<>();
			
		
		for (Breed br : capi.findAllBreeds()) {
			String id = br.getId();
			CatResponse breed= capi.findBreed(id);
			breed.setHeight( (int) (breed.getHeight()*0.2));
			breed.setWidth( (int) (breed.getWidth()*0.2));
			Integer power = br.getAdaptability() + br.getAffection_level() +
					br.getChild_friendly() + br.getDog_friendly() + br.getEnergy_level() +
					br.getGrooming() + br.getIntelligence() + br.getShedding_level() +
					br.getSocial_needs() + br.getStranger_friendly() + br.getVocalisation();
			powers.add(power);
			images.add(breed);
		}
		
		System.out.println(capi.findAllBreeds().length);
		
		ModelAndView mav = new ModelAndView("cats");
		mav.addObject("breeds", capi.findAllBreeds());
		mav.addObject("powers", powers);
		mav.addObject("images", images);
		
		return mav;
	}

}
