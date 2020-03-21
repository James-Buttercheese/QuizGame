package co.grandcircus.QuizGame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



//This Controller is temporary - WILL DELETE LATER



@Controller
public class TestingController {
	
	@RequestMapping("/test")
	public ModelAndView test() {
		return new ModelAndView("test");
	}
}
