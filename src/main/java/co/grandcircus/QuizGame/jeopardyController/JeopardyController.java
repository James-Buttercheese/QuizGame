package co.grandcircus.QuizGame.jeopardyController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import co.grandcircus.QuizGame.JeopardyAPI;
import co.grandcircus.QuizGame.jeopardyEntities.Clue;

@Controller
public class JeopardyController {
	
	// Problem with \' on the answers
	
	
	private static String category;
	private static String question;
	private static String correctAnswer;
//	private static Integer difficulty;
	private static List<String> answers; //maybe not
	
	
	@Autowired
	private JeopardyAPI jeopApi;
	
	@RequestMapping("/jeopardy")
	public ModelAndView home() {	
		return new ModelAndView("jeopardyHome");
	}
	
	@RequestMapping("/jeopardy/game")
	public ModelAndView game(@RequestParam("diff") Integer difficulty) {
		
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
		
//		System.out.println("First round of answers: ");
//		for (String answer: answers) {
//			System.out.println(answer);
//		}
		
		
		return mav;
		
		
	}
	
	@PostMapping("/jeopardy/game")
	public ModelAndView result(//@RequestParam("category") String category,
			@RequestParam("difficulty") String difficulty,
			//@RequestParam("question") String question,
			//@RequestParam("correctAnswer") String correctAnswer,
			//@RequestParam("answers") String[] answers,
			@RequestParam("answer") String answer) {

		// Compute points here
		
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
		
		
		ModelAndView mav = new ModelAndView("jeopardyResult");
		mav.addObject("category", category);
		mav.addObject("difficulty", difficulty);
		mav.addObject("question", question);
		mav.addObject("answers", answers);
		mav.addObject("correctAnswer", correctAnswer);

		return mav;
	}
	
	

}
