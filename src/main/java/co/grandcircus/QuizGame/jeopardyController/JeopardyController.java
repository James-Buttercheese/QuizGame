package co.grandcircus.QuizGame.jeopardyController;

import java.util.ArrayList;
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
		Set<String> answers = new HashSet<>();
		answers.add(mainClue.getAnswer());    
//		System.out.println(mainClue.getAnswer());
		
		for (int i=0; i<20; i++) {   
			Clue randomClue = jeopApi.generateRandomClue(cluesInCategory);
//			if (!randomClues.contains(randomClue)) {   The Api has duplicate clues in different ids
			if (!answers.contains(randomClue.getAnswer()) && !randomClue.getAnswer().isEmpty()) {
//				randomClues.add(randomClue);
				answers.add(randomClue.getAnswer()); 
			}
			if (answers.size() == 5) {
				break;
			}			
		}
		
		ModelAndView mav = new ModelAndView("jeopardyGame");
		mav.addObject("mainClue", mainClue);
//		mav.addObject("randomClues", randomClues);
		mav.addObject("answers", answers);
		
		return mav;
		
		
	}
	
	@PostMapping("/jeopardy/game")
	public ModelAndView result(@RequestParam("category") String category,
			@RequestParam("difficulty") String difficulty,
			@RequestParam("question") String question,
			@RequestParam("correctAnswer") String correctAnswer,
			@RequestParam("answers") String[] answers,
			@RequestParam("answer") String answer) {

		// Compute points here
		
		System.out.println(category);
		System.out.println(difficulty);
		System.out.println(question);
		System.out.println(correctAnswer);
		System.out.println(answers);
		
		System.out.println(answers[0]);
		System.out.println(answers[answers.length-1]); //waiting for this error here!
		
		answers[0] = answers[0].substring(1);
		answers[answers.length-1] = answers[answers.length-1].substring(0,answers[answers.length-1].length()-1);
		
		
		
		ModelAndView mav = new ModelAndView("jeopardyResult");
		mav.addObject("category", category);
		mav.addObject("difficulty", difficulty);
		mav.addObject("question", question);
		mav.addObject("answers", answers);
		mav.addObject("correctAnswer", correctAnswer);

		return mav;
	}
	
	

}
