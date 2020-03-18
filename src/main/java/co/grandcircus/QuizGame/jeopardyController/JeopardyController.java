package co.grandcircus.QuizGame.jeopardyController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.JeopardyAPI;
import co.grandcircus.QuizGame.PlacesAPI;
import co.grandcircus.QuizGame.jeopardyEntities.Clue;
import co.grandcircus.QuizGame.placesEntities.Result;

@Controller
public class JeopardyController {
	
	// Problem with \' on the answers
	
	
	private static String category;
	private static String question;
	private static String correctAnswer;
	private static String diffName;
//	private static Integer difficulty;
	private static List<String> answers; //maybe not
	
	@Autowired
	private HttpSession sesh;

	@Autowired
	private JeopardyAPI jeopApi;
	
	@Autowired
	private PlacesAPI papi;
	
//	@RequestMapping("/jeopardy")
//	public ModelAndView home() {	
//		return new ModelAndView("jeopardyHome");
//	}
	
	@RequestMapping("/jeopardy")
	public ModelAndView game(@RequestParam("placeId") String placeId, //string?
			@RequestParam("mapId") Long mapId) {
		
		///jeopardy?placeId=A&mapId=B
		
		Result result = papi.getById(placeId);
		Double rating = result.getRating();
		
		//System.out.println(rating);
		
		Integer difficulty = 0;
		diffName = "";
		
		if (rating <= 0.625) {
			difficulty = 100;
			diffName = "Easy";
		} else if (rating <= 1.25) {
			difficulty = 200;
			diffName = "Easy";
		} else if (rating <= 1.875) {
			difficulty = 300;
			diffName = "Easy";
		} else if (rating <= 2.5) {
			difficulty = 400;
			diffName = "Medium";
		} else if (rating <= 3.125) {
			difficulty = 500;
			diffName = "Medium";
		} else if (rating <= 3.75) {
			difficulty = 600;
			diffName = "Medium";
		} else if (rating <= 4.375) {
			difficulty = 800;
			diffName = "Hard";
		} else if (rating <= 5) {
			difficulty = 1000;
			diffName = "Hard";
		}
		
		Integer randomOffset = jeopApi.generateRandomOffsetByDifficulty(difficulty);
		
		Clue[] allClues = jeopApi.findByDifficulty(difficulty, randomOffset);
		
		Clue mainClue = jeopApi.generateRandomClue(allClues);
		while (mainClue.getQuestion().isEmpty()) {
		mainClue = jeopApi.generateRandomClue(allClues);
		}
		
		Integer categoryId = mainClue.getCategory_id();
//		Integer categoryId = 2578;
		System.out.println("Category Id: " + categoryId);
		
		Clue[] cluesInCategory = jeopApi.findByCategory(categoryId); //dont use difficulty
//		System.out.println("Number of clues in cat: " + cluesInCategory.length);
		
//		List<Clue> randomClues = new ArrayList<>();
		Set<String> randomAnswers = new HashSet<>();
		randomAnswers.add(mainClue.getAnswer());    
//		System.out.println(mainClue.getAnswer());
		
		for (int i=0; i<20; i++) {   
			Clue randomClue = jeopApi.generateRandomClue(cluesInCategory);
//			if (!randomClues.contains(randomClue)) {   The Api has duplicate clues in different ids
			if (!randomAnswers.contains(randomClue.getAnswer()) && !randomClue.getAnswer().isEmpty()) {
//				randomClues.add(randomClue);
				randomAnswers.add(randomClue.getAnswer()); 
			}
			if (randomAnswers.size() == 5) {
				break;
			}			
		}
		
		for (String randomAnswer : randomAnswers) {
			System.out.println("Answer :" + randomAnswer);
		}
		
		answers = new ArrayList<>();
		for (String randomAnswer : randomAnswers) {
			answers.add(randomAnswer);
		}
		
		category = mainClue.getCategory().getTitle();
		question = mainClue.getQuestion();
		correctAnswer = mainClue.getAnswer();
//		difficulty = mainClue.getValue();
		
		ModelAndView mav = new ModelAndView("jeopardyGame");
		mav.addObject("mainClue", mainClue);
		System.out.println("First Category: " + category);
		System.out.println("First Question: " + question);
		System.out.println("First Difficulty: " + difficulty);
//		mav.addObject("randomClues", randomClues);
		mav.addObject("answers", answers);
		mav.addObject("diffName",diffName);
		
		System.out.println(mapId);
		
		mav.addObject("mapId", mapId);
		
//		System.out.println("First round of answers: ");
//		for (String answer: answers) {
//			System.out.println(answer);
//		}
		
		
		return mav;
		
		
	}
	
	@PostMapping("/jeopardy")
	public ModelAndView result(//@RequestParam("category") String category,
			@RequestParam("difficulty") String difficulty,
			//@RequestParam("question") String question,
			//@RequestParam("correctAnswer") String correctAnswer,
			//@RequestParam("answers") String[] answers,
			@RequestParam("answer") String answer,
			@RequestParam("mapId") Long mapId) {

		// Compute points here
		
		String correct = "";
		if (answer.equals(correctAnswer)) {
			correct = "You won!";
		} else {
			correct = "You lost!";
		}

		
		System.out.println("Second Category: " + category);		   //sometimes this gets null
		System.out.println("Second Question: " + question);  //sometimes this gets null. Sometimes gets a different question
		System.out.println("Second Difficulty: " + difficulty);
		
		
		System.out.println("Second round of answers: ");
		for (String ans: answers) {
			System.out.println(ans);
		}
		
		System.out.println("Correct Answer: " + correctAnswer);     //sometimes this gets null  <i>Movin\' Out</i>
		
		System.out.println(answers.get(0));        //[<i>Movin\' Out</i>
		System.out.println(answers.get(answers.indexOf(answers.get(answers.size()-1)))); //waiting for this error here! //sometimes this gets null (in the example above)
		
		//answers.set(0, answers.get(0).substring(1));
		//answers.set(answers.size()-1, answers.get(answers.size()-1).substring(0, answers.size()-1));
		
		
		System.out.println(mapId);
		
		ModelAndView mav = new ModelAndView("jeopardyResult");
		
		mav.addObject("mapId", mapId);
		mav.addObject("correct", correct);
		mav.addObject("diffName", diffName);
		mav.addObject("category", category);
		mav.addObject("difficulty", difficulty);
		mav.addObject("question", question);
		mav.addObject("answers", answers);
		mav.addObject("correctAnswer", correctAnswer);

		return mav;
	}
	
	@RequestMapping("/summary")
	public ModelAndView summary(@RequestParam("mapId") Long mapId,
			@RequestParam("correct") String correct) {
		
		ModelAndView mav = new ModelAndView("summary");
		mav.addObject("mapId", mapId);
		mav.addObject("correct", correct);
		System.out.println("MapId: " + mapId);
		return mav;
		
	}
	
	
	

}

