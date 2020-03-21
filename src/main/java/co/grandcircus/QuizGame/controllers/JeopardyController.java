package co.grandcircus.QuizGame.controllers;

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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.JeopardyAPI;
import co.grandcircus.QuizGame.PlacesAPI;
import co.grandcircus.QuizGame.entities.PiD;
import co.grandcircus.QuizGame.entities.Player;
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
	private static List<String> answers; // maybe not
	public static boolean isBoss;

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
	public ModelAndView game(@RequestParam(name = "placeId", required = false) String placeId, // string?
			@RequestParam(name = "mapId", required = false) Long mapId,
			@SessionAttribute(name = "player", required = false) Player player) {

		/// jeopardy?placeId=A&mapId=B
		ModelAndView mav = new ModelAndView("jeopardyGame");
		Result result = papi.getById(placeId);
		Double rating = result.getRating();
		
		if (placeId != null) {
			player.getVisited().add(new PiD(placeId));
		}

		// System.out.println(rating);
		Integer difficulty = 0;
		isBoss = false;
		if (player.getWinCount() == 3) {
			isBoss = true;
			diffName = "Boss";
			difficulty = 1000;
		} else {
			diffName = "";

			if (rating <= 0.625) {
				difficulty = 100;
				diffName = "Easy";
			} else if (rating <= 1.25) {
				difficulty = 100;
				diffName = "Easy";
			} else if (rating <= 1.875) {
				difficulty = 100;
				diffName = "Easy";
			} else if (rating <= 2.5) {
				difficulty = 100;
				diffName = "Easy";
			} else if (rating <= 3.125) {
				difficulty = 100;
				diffName = "Easy";
			} else if (rating <= 3.75) {
				difficulty = 100;
				diffName = "Easy";
			} else if (rating <= 4.375) {
				difficulty = 500;
				diffName = "Medium";
			} else if (rating <= 5) {
				difficulty = 1000;
				diffName = "Hard";
			}

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

		Clue[] cluesInCategory = jeopApi.findByCategory(categoryId); // dont use difficulty
//		System.out.println("Number of clues in cat: " + cluesInCategory.length);

//		List<Clue> randomClues = new ArrayList<>();
		Set<String> randomAnswers = new HashSet<>();
		randomAnswers.add(mainClue.getAnswer());
//		System.out.println(mainClue.getAnswer());

		for (int i = 0; i < 20; i++) {
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

		mav.addObject("mainClue", mainClue);
		System.out.println("First Category: " + category);
		System.out.println("First Question: " + question);
		System.out.println("First Difficulty: " + difficulty);
//		mav.addObject("randomClues", randomClues);
		mav.addObject("answers", answers);
		mav.addObject("diffName", diffName);

		System.out.println(mapId);
		
		System.out.println("Is boss?" + isBoss);

		mav.addObject("mapId", mapId);

//		System.out.println("First round of answers: ");
//		for (String answer: answers) {
//			System.out.println(answer);
//		}

		return mav;

	}

	@PostMapping("/jeopardy")
	public ModelAndView result(// @RequestParam("category") String category,
			@RequestParam("difficulty") String difficulty,
			// @RequestParam("question") String question,
			// @RequestParam("correctAnswer") String correctAnswer,
			// @RequestParam("answers") String[] answers,
			@RequestParam("answer") String answer, @RequestParam(name = "mapId", required = false) Long mapId,
			@SessionAttribute(name = "player", required = false) Player player) {
		Integer energy = 0;
		Integer wins = 0;
		String correct = "";
		// Compute points here
		if (player != null) {
			System.out.println(player.toString());
			energy = player.getEnergy();
			wins = player.getWinCount();
		

			if (answer.equals(correctAnswer)) {
				correct = "You won!";
				if (diffName.equals("Easy")) {
					energy += 5;
					wins += 1;
					player.setEnergy(energy);
					player.setWinCount(wins);
				} else if (diffName.equals("Medium")) {
					energy += 10;
					wins += 1;
					player.setEnergy(energy);
					player.setWinCount(wins);
				} else {
					System.out.println(player.toString());
					wins += 1;
					energy += 15;
					player.setEnergy(energy);
					player.setWinCount(wins);
				}
			} else {
				correct = "You lost!";
				
			}
		} else {
			correct = "null :(";
			System.out.println("null :(");
		}

		System.out.println("Second Category: " + category); // sometimes this gets null
		System.out.println("Second Question: " + question); // sometimes this gets null. Sometimes gets a different
															// question
		System.out.println("Second Difficulty: " + difficulty);

		System.out.println("Second round of answers: ");
		for (String ans : answers) {
			System.out.println(ans);
		}

		System.out.println("Correct Answer: " + correctAnswer); // sometimes this gets null <i>Movin\' Out</i>

		System.out.println(answers.get(0)); // [<i>Movin\' Out</i>
		System.out.println(answers.get(answers.indexOf(answers.get(answers.size() - 1)))); // waiting for this error
																							// here! //sometimes this
																							// gets null (in the example
																							// above)

		// answers.set(0, answers.get(0).substring(1));
		// answers.set(answers.size()-1, answers.get(answers.size()-1).substring(0,
		// answers.size()-1));

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
		System.out.println(player.toString());

		return mav;
	}

	@RequestMapping("/summary")
	public ModelAndView summary(@RequestParam(name="mapId",required=false) Long mapId, @RequestParam("correct") String correct,
			@SessionAttribute(name = "player", required = false) Player player) {
		Double dist = 0.;
		
		if (player != null) {
		dist = getDifference(player);
		}
		if (dist != 0) {
			int energy = (int) (dist * 10);
			System.out.println(energy);
			player.setEnergy(player.getEnergy()-energy);
		}
		
		ModelAndView mav = new ModelAndView("summary");
		if (player.getEnergy() == 0) {
			mav.addObject("energy", player.getEnergy());
			mav.addObject("wins", player.getWinCount());
			mav.addObject("correct", correct);
			mav.addObject("gameOver", "Game Over.");
			mav.addObject("isBoss", isBoss);
		} else {
			mav.addObject("mapId", mapId);
			mav.addObject("energy", player.getEnergy());
			mav.addObject("wins", player.getWinCount());
			mav.addObject("correct", correct);
			mav.addObject("isBoss", isBoss);
		}
		return mav;

	}
	
	public double getDifference(@SessionAttribute(name="player", required = false)Player player) {
		
		if (player == null) {
			return 0.0;
		}
		
		String startId = player.getVisited().get(player.getVisited().size()-2).getId();
		String endId = player.getVisited().get(player.getVisited().size()-1).getId();
		Double startLat = papi.getById(startId).getGeometry().getLocation().getLat();
		Double startLng = papi.getById(startId).getGeometry().getLocation().getLng();
		Double endLat = papi.getById(endId).getGeometry().getLocation().getLat();
		Double endLng = papi.getById(endId).getGeometry().getLocation().getLng();
		
		double theta = startLng - endLng;
		double dist = Math.sin(Math.toRadians(startLat)) * Math.sin(Math.toRadians(endLat)) + Math.cos(Math.toRadians(startLat)) * Math.cos(Math.toRadians(endLat)) * Math.cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;
		
		return dist;
	}

}
