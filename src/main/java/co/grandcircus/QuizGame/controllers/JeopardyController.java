package co.grandcircus.QuizGame.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.QuizGame.CatAPI;
import co.grandcircus.QuizGame.JeopardyAPI;
import co.grandcircus.QuizGame.PlacesAPI;
import co.grandcircus.QuizGame.catEntities.Breed;
import co.grandcircus.QuizGame.catEntities.CatResponse;
import co.grandcircus.QuizGame.entities.Card;
import co.grandcircus.QuizGame.entities.Cards;
import co.grandcircus.QuizGame.entities.Item;
import co.grandcircus.QuizGame.entities.PiD;
import co.grandcircus.QuizGame.entities.Player;
import co.grandcircus.QuizGame.entities.User;
import co.grandcircus.QuizGame.jeopardyEntities.Clue;
import co.grandcircus.QuizGame.placesEntities.Result;
import co.grandcircus.QuizGame.repositories.ItemRepo;
import co.grandcircus.QuizGame.repositories.PinRepo;
import co.grandcircus.QuizGame.repositories.UserRepo;

@Controller
public class JeopardyController {

	// Problem with \' on the answers
	// Problem with images on the questions

	private static String category;
	private static String question;
	private static String correctAnswer;
	private static String diffName;
	private static Integer difficulty;
	private static List<String> answers;
	public static boolean isBoss; // see if change public
	// maybe mapId?

	@Autowired
	private HttpSession sesh;

	@Autowired
	private JeopardyAPI jeopApi;

	@Autowired
	private PlacesAPI papi;

	@Autowired
	private CatAPI capi;

	@Autowired
	private UserRepo userdao;

	@Autowired
	private PinRepo pinrepo;

	@Autowired
	private ItemRepo itemrepo;

	@RequestMapping("/jeopardy")
	public ModelAndView game(@RequestParam(name = "placeId", required = false) String placeId,
			@RequestParam(name = "mapId", required = false) Long mapId,
			@RequestParam(name = "userId", required = false) Long userId,
			@SessionAttribute(name = "player", required = false) Player player,
			@SessionAttribute(name = "cards", required = false) Cards cards
			/*@RequestParam(name = "cardId", required = false) String cardId*/) {

		ModelAndView mav = new ModelAndView("jeopardyGame");
		mav.addObject("userId", userId);

		Result result = papi.getById(placeId);
		Double rating = result.getRating();

		difficulty = 0;
		Integer[] difficultiesE = new Integer[3];
		Integer[] difficultiesM = new Integer[3];
		Integer[] difficultiesH = new Integer[2];
		Random rand = new Random();
		Integer randNum = null;
		Card card = null;

		if (placeId != null) {
			player.getVisited().add(new PiD(placeId));
		}

		isBoss = false;

//		if (player.getWinCount() == 3) {
////			isBoss = true;
////			diffName = "Boss";
////			difficulty = 1000;			
//			return new ModelAndView("redirect:/boss-battle");
//		} else {
		diffName = "";
		if (rating < 4.3) {
			difficultiesE[0] = 100;
			difficultiesE[1] = 200;
			difficultiesE[2] = 300;
			randNum = rand.nextInt(difficultiesE.length - 1);
			difficulty = difficultiesE[randNum];
			diffName = "Easy";
		} else if (rating < 4.6) {
			difficultiesM[0] = 400;
			difficultiesM[1] = 500;
			difficultiesM[2] = 600;
			randNum = rand.nextInt(difficultiesM.length - 1);
			difficulty = difficultiesM[randNum];
			diffName = "Medium";
		} else if (rating <= 5.0) {
			difficultiesH[0] = 800;
			difficultiesH[1] = 1000;
			randNum = rand.nextInt(difficultiesH.length - 1);
			difficulty = difficultiesH[randNum];
			diffName = "Hard";
		}
		System.out.println(randNum);
//		}

		Clue[] allClues = jeopApi.findByCategoryAndDifficulty(difficulty);
		Clue mainClue = null;
		do {
			mainClue = jeopApi.generateRandomClue(allClues);
		} while (mainClue.getQuestion().isEmpty());

//		System.out.println("amanda".replaceAll("\\\\", ""));
//		System.out.println("ama\'nda".replaceAll("\\\\", ""));

		mainClue.setQuestion(mainClue.getQuestion().replaceAll("\\\\", ""));

		Integer categoryId = mainClue.getCategory_id();

		Clue[] cluesInCategory = jeopApi.findByCategory(categoryId);

		Set<String> randomAnswers = new HashSet<>();
		randomAnswers.add(mainClue.getAnswer());

		for (int i = 0; i < 20; i++) {
			Clue randomClue = jeopApi.generateRandomClue(cluesInCategory);
			if (!randomAnswers.contains(randomClue.getAnswer()) && !randomClue.getAnswer().isEmpty()) {
				randomAnswers.add(randomClue.getAnswer());
			}
			if (randomAnswers.size() == 5) {
				break;
			}
		}

		answers = new ArrayList<>();
		for (String randomAnswer : randomAnswers) {
			randomAnswer = randomAnswer.replaceAll("\\\\", "");
			answers.add(randomAnswer);
		}

		category = mainClue.getCategory().getTitle();
		question = mainClue.getQuestion();
		correctAnswer = mainClue.getAnswer();

// ADD CAT TO BE COLLECTED
		do {
			card = capi.generateCard(difficulty);
			String temp = card.getTemperament();
			String[] tempArr = temp.split(",");
			temp = tempArr[0];
			mav.addObject("catName", card.getName());
			mav.addObject("catUrl", card.getUrl());
			mav.addObject("cardId",card.getId());
			mav.addObject("temperament", temp);
			System.out.println("Card: " + card);

		} while (cards.getCatCardsNames().contains(card.getName())); // may fall in inf loop if game is too long

		System.out.println("Answer on Request: " + answers);
		System.out.println("Correct Answer on Request: " + correctAnswer);

		mav.addObject("mainClue", mainClue);
		mav.addObject("answers", answers);
		mav.addObject("diffName", diffName);
		mav.addObject("mapId", mapId); // maybe not pass it?

		return mav;

	}

	@PostMapping("/jeopardy")
	public ModelAndView result(@RequestParam("answer") String answer,
			@RequestParam(name = "mapId", required = false) Long mapId, // maybe up top
			@RequestParam(name = "userId", required = false) Long userId,
			@SessionAttribute(name = "player", required = false) Player player,
			@SessionAttribute(name = "cards", required = false) Cards cards,
			@RequestParam(name = "cardId", required = false) String cardId,
			@RequestParam(name = "catName", required = false) String catName,
			@RequestParam(name = "catUrl", required = false) String catUrl,
			@RequestParam(name = "temperament", required = false) String temperament,
			@RequestParam(name="category", required=false) String category// ,
	/* @SessionAttribute(name = "cardsNames", required = false) Cards cardsNames */) {

		ModelAndView mav = new ModelAndView("jeopardyResult");
		mav.addObject("userId", userId);

		Integer energy = 0;
		Integer wins = 0;
		String correct = "";
		Card card = new Card();

		System.out.println("Answer on Post: " + answer);
		System.out.println("Correct Answer on Post: " + correctAnswer);

		if (player != null) {
			energy = player.getEnergy();
			wins = player.getWinCount();

			if (answer.equals(correctAnswer.split("\"")[0])) { // For correct answers with "
				correct = "You won!";
				wins++;
				player.setWinCount(wins);
				
				CatResponse res = capi.findBreed(cardId);
				card.setId(res.getBreeds().get(0).getId());
				card.setName(res.getBreeds().get(0).getName());
				card.setTemperament(res.getBreeds().get(0).getTemperament());
				card.setOrigin(res.getBreeds().get(0).getOrigin());
				card.setDescription(res.getBreeds().get(0).getDescription());
				card.setAdaptability(res.getBreeds().get(0).getAdaptability());
				card.setAffection_level(res.getBreeds().get(0).getAffection_level());
				card.setChild_friendly(res.getBreeds().get(0).getChild_friendly());
				card.setDog_friendly(res.getBreeds().get(0).getDog_friendly());
				card.setEnergy_level(res.getBreeds().get(0).getEnergy_level());
				card.setGrooming(res.getBreeds().get(0).getGrooming());
				card.setHealth_issues(res.getBreeds().get(0).getHealth_issues());
				card.setIntelligence(res.getBreeds().get(0).getIntelligence());
				card.setShedding_level(res.getBreeds().get(0).getShedding_level());
				card.setSocial_needs(res.getBreeds().get(0).getSocial_needs());
				card.setStranger_friendly(res.getBreeds().get(0).getStranger_friendly());
				card.setVocalisation(res.getBreeds().get(0).getVocalisation());
				card.setUrl(res.getUrl());
				card.setWidth(res.getWidth());
				card.setHeight(res.getHeight());
//				do {
//					card = capi.generateCard(difficulty);
//
//					// System.out.println("Card: " + card);
//
//				} while (cards.getCatCardsNames().contains(card.getName())); // may fall in inf loop if game is too long

				List<Item> cardsInDb = itemrepo.findByUserId(userId);
				List<String> cardsInDbNames = new ArrayList<>();
				for (Item cd : cardsInDb) {
					cardsInDbNames.add(cd.getCardName()); // may cause slow
				}

				Item item = new Item();
//				item.setCard(card.getName());   
				item.setCard(card.getId());        //here!
				User user = userdao.getOne(userId);
				item.setUser(user);

				if (!cardsInDbNames.contains(item.getCardName())) {
					itemrepo.save(item);
				}

				cards.addCard(card);
//				cards.addCardName(card.getName());
				cards.addCardName(card.getId());

				// System.out.println(cards.getCatCardsNames());

				if (diffName.equals("Easy")) {
					energy += 5;
				} else if (diffName.equals("Medium")) {
					energy += 10;
				} else {
					energy += 15;
				}
				player.setEnergy(energy);
			} else {
				cardId = null;
				correct = "You lost!";
				if (diffName.equals("Easy")) {
					energy -= 15;
				} else if (diffName.equals("Medium")) {
					energy -= 10;
				} else {
					energy -= 5;
					player.setEnergy(energy);
				}
				player.setEnergy(energy);
			}
		} else {
			correct = "null :(";
		}

		if (card != null) {
			mav.addObject("card", card);
		}
		
//		System.out.println("card on result: " + card);

		mav.addObject("card", card);
		mav.addObject("cardId",cardId);
		mav.addObject("catUrl",catUrl);
		mav.addObject("catName",catName);
		mav.addObject("temperament", temperament);
		mav.addObject("category",category);
		mav.addObject("question", question);
		mav.addObject("correctAnswer", correctAnswer);
		mav.addObject("answers", answers); //
		mav.addObject("diffName", diffName);
		mav.addObject("category", category);
		mav.addObject("correct", correct); // maybe put it as a static variable
		mav.addObject("mapId", mapId); // maybe not pass it?

		return mav;
	}

	@RequestMapping("/summary")
	public ModelAndView summary(@RequestParam(name = "mapId", required = false) Long mapId,
			@RequestParam("correct") String correct, // maybe not
			@RequestParam(name = "userId", required = false) Long userId,
			@RequestParam(name = "cardId", required = false) String cardId,
			@RequestParam(name = "catName", required = false) String catName,
			@RequestParam(name = "catUrl", required = false) String catUrl,
			@RequestParam(name = "temperament", required = false) String temperament,
			@SessionAttribute(name = "player", required = false) Player player,
			@SessionAttribute(name = "cards", required = false) Cards cards) {

		Double dist = 0.;

		if (player != null) {
			dist = getDifference(player);
		}
		if (dist != 0) {
			int energy = (int) (dist * 10);
			System.out.println(energy);
			player.setEnergy(player.getEnergy() - energy);
		}

		ModelAndView mav = new ModelAndView("summary");
		mav.addObject("userId", userId);

		if (player.getEnergy() <= 0) {
			mav.addObject("gameOver", "Game Over.");

		} else {
			mav.addObject("mapId", mapId);
		}

//		System.out.println("cardid on summary: " + cardId);
//		System.out.println("All cards: " + cards.getCatCards());
//		System.out.println("Length: " + cards.getCatCards().size());

		if (cardId != null && correct.equalsIgnoreCase("You won!")) {
			//mav.addObject("cardName", capi.findBreed(cardId).getBreeds().get(0).getName());

			mav.addObject("cardName", capi.findBreed(cardId).getBreeds().get(0).getName());
			mav.addObject("cardTemperament", capi.findBreed(cardId).getBreeds().get(0).getTemperament());
			mav.addObject("cardOrigin", capi.findBreed(cardId).getBreeds().get(0).getOrigin());
			mav.addObject("cardDescription", capi.findBreed(cardId).getBreeds().get(0).getDescription());
			mav.addObject("cardUrl", capi.findBreed(cardId).getUrl());
			mav.addObject("cardWidth", capi.findBreed(cardId).getWidth() * 0.3);
			mav.addObject("cardHeight", capi.findBreed(cardId).getHeight() * 0.3);
		}

		CatResponse space = capi.findCatInSpace();
		mav.addObject("lostUrl", space.getUrl());
		mav.addObject("lostWidth", space.getWidth() * 0.5);
		mav.addObject("lostHeight", space.getWidth() * 0.5);

		mav.addObject("isBoss", isBoss);
		mav.addObject("correct", correct);
		mav.addObject("energy", player.getEnergy());
		mav.addObject("wins", player.getWinCount());

		return mav;
	}

	@RequestMapping("/boss-battle")
	public ModelAndView boss(@SessionAttribute(name = "cards", required = false) Cards cards,
			@RequestParam(name = "tied", required = false) String tied,
			@RequestParam(name = "userId", required = false) Long userId) {

		List<Card> myCatCards = cards.getCatCards();

//		System.out.println(myCatCards);

		Card bossCard = capi.generateBossCard();

		ModelAndView mav = new ModelAndView("boss");
		mav.addObject("myCatCards", myCatCards);
		mav.addObject("bossCard", bossCard);
		mav.addObject("bossWidth", bossCard.getWidth() * 0.3);
		mav.addObject("bossHeight", bossCard.getHeight() * 0.3);

		if (userId != null) {
			mav.addObject("userId", userId);
		}

		if (tied != null) {
			mav.addObject("tied", tied);
		}

		return mav;
	}

	@PostMapping("/boss-battle")
	public ModelAndView boss(@RequestParam("battleCardId") String battleCardId,
			@RequestParam("bossCardId") String bossCardId, @RequestParam("feature") String feature,
			@RequestParam(name = "userId", required = false) Long userId,
			@SessionAttribute(name = "player", required = false) Player player) {
		CatResponse catResponseUser = capi.findBreed(battleCardId);
		Breed breedUser = catResponseUser.getBreeds().get(0);

		CatResponse catResponseBoss = capi.findBreed(bossCardId);
		Breed breedBoss = catResponseBoss.getBreeds().get(0);
//TODO: ADD LIST OF FEATURES TO PULL PARTY'S STATS FROM
		Integer pointUser = 0;
		Integer pointBoss = 0;

		switch (feature) {
		case "adaptability":
			pointUser = breedUser.getAdaptability();
			pointBoss = breedBoss.getAdaptability();
			break;
		case "affection_level":
			pointUser = breedUser.getAffection_level();
			pointBoss = breedBoss.getAffection_level();
			break;
		case "child_friendly":
			pointUser = breedUser.getChild_friendly();
			pointBoss = breedBoss.getChild_friendly();
			break;
		case "dog_friendly":
			pointUser = breedUser.getDog_friendly();
			pointBoss = breedBoss.getDog_friendly();
			break;
		case "energy_level":
			pointUser = breedUser.getEnergy_level();
			pointBoss = breedBoss.getEnergy_level();
			break;
		case "grooming":
			pointUser = breedUser.getGrooming();
			pointBoss = breedBoss.getGrooming();
			break;
		case "intelligence":
			pointUser = breedUser.getIntelligence();
			pointBoss = breedBoss.getIntelligence();
			break;
		case "shedding_level":
			pointUser = breedUser.getShedding_level();
			pointBoss = breedBoss.getShedding_level();
			break;
		case "social_needs":
			pointUser = breedUser.getSocial_needs();
			pointBoss = breedBoss.getSocial_needs();
			break;
		case "stranger_friendly":
			pointUser = breedUser.getStranger_friendly();
			pointBoss = breedBoss.getStranger_friendly();
			break;
		case "vocalisation":
			pointUser = breedUser.getVocalisation();
			pointBoss = breedBoss.getVocalisation();
			break;
		}

		System.out.println("Point User: " + pointUser);
		System.out.println("Point Boss: " + pointBoss);

		String result = "";
		if (pointUser > pointBoss) {
			result = "You won! Your " + feature + ": " + pointUser + " Boss " + feature + ": " + pointBoss;
			if (userId != null) {
				if (player != null) {
					User user = userdao.findById(userId).orElse(null);
					user.setScore(user.getScore() + player.getEnergy());
					user.setWins(user.getWins() + 1);
					userdao.save(user);
				}
			}

		} else if (pointUser < pointBoss) {
			result = "You lost! Your " + feature + ": " + pointUser + " Boss " + feature + ": " + pointBoss;
			;
		} else {
			ModelAndView mav = new ModelAndView("redirect:/boss-battle");
			mav.addObject("tied", "You tied!");
			if (userId != null) {
				mav.addObject("userId", userId);
			}
			return mav;
		}

		// mav.addObject("cat", breed);
		// mav.addObject("bossCardId", bossCardId);

		return new ModelAndView("finale", "result", result);

	}

	public double getDifference(@SessionAttribute(name = "player", required = false) Player player) {

		if (player == null) {
			return 0.0;
		}

		String startId = player.getVisited().get(player.getVisited().size() - 2).getId();
		String endId = player.getVisited().get(player.getVisited().size() - 1).getId();
		Double startLat = papi.getById(startId).getGeometry().getLocation().getLat();
		Double startLng = papi.getById(startId).getGeometry().getLocation().getLng();
		Double endLat = papi.getById(endId).getGeometry().getLocation().getLat();
		Double endLng = papi.getById(endId).getGeometry().getLocation().getLng();

		double theta = startLng - endLng;
		double dist = Math.sin(Math.toRadians(startLat)) * Math.sin(Math.toRadians(endLat))
				+ Math.cos(Math.toRadians(startLat)) * Math.cos(Math.toRadians(endLat))
						* Math.cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;

		return dist;
	}

}
