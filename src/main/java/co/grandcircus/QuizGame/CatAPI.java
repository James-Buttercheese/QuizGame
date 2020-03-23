package co.grandcircus.QuizGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.QuizGame.catEntities.Breed;
import co.grandcircus.QuizGame.catEntities.CatResponse;
import co.grandcircus.QuizGame.entities.Card;

@Component
public class CatAPI {
	
	private RestTemplate rt;

	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "ooeeee!");
			return execution.execute(request, body);
		};
		rt = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}
	
	@Value("${catKey}")
	private String catKey;
	
	public Breed[] findAllBreeds(){
		
		String url = "https://api.thecatapi.com/v1/breeds";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-api-key", catKey);
		
		
		Breed[] breeds = null;
		try {
 		breeds = rt.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), Breed[].class).getBody();
		} catch(RestClientException e) {
			System.out.println("Definition not found!");
		}
 		
		return breeds;
			
	}
	
	public CatResponse findBreed(String id) {
		
		String url = "https://api.thecatapi.com/v1/images/search?breed_ids=" + id;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-api-key", catKey);
		
		
		CatResponse[] response = null;
		try {
 		response = rt.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), CatResponse[].class).getBody();
		} catch(RestClientException e) {
			System.out.println("Definition not found!");
		}
		
		CatResponse res = response[0];    //error here
		
		return res;
		
	}
	
	public Card generateCard(Integer difficulty) {
		
		List<String> breedIds100 = new ArrayList<>(Arrays.asList("rblu","lihu", "esho", "pers", "hima"));
		List<String> breedIds200 = new ArrayList<>(Arrays.asList("emau","bsho", "amau", "dons", "awir", "sfol", "srex"));
		List<String> breedIds300 = new ArrayList<>(Arrays.asList("birm","khao", "ragd", "nebe", "cspa", "asho", "acur"));
		List<String> breedIds400 = new ArrayList<>(Arrays.asList("mala","hbro", "crex", "csho", "char", "bamb", "abob", "aege", "kora", "abys", "pixi"));
		List<String> breedIds500 = new ArrayList<>(Arrays.asList("sibe","raga", "norw", "mcoo", "drex", "cypr", "chee", "chau", "buri", "bslo", "lape", "java"));
		List<String> breedIds600 = new ArrayList<>(Arrays.asList("sing","sava", "bomb", "amis", "sphy", "soma", "ebur"));
		List<String> breedIds800 = new ArrayList<>(Arrays.asList("toyg","orie", "ocic", "munc", "manx", "kuri", "beng", "tang", "snow", "siam", "bure", "tvan"));
		List<String> breedIds1000 = new ArrayList<>(Arrays.asList("ycho","tonk", "jbob", "cymr", "ctif", "bali"));
																										
		
		String breedId = "";
		Random rand = new Random();
		if (difficulty == 100) {
			int randomNumber = rand.nextInt(breedIds100.size());
			breedId = breedIds100.get(randomNumber);
		} else if (difficulty ==200) {
			int randomNumber = rand.nextInt(breedIds200.size());
			breedId = breedIds200.get(randomNumber);
		} else if (difficulty ==300) {
			int randomNumber = rand.nextInt(breedIds300.size());
			breedId = breedIds300.get(randomNumber);
		} else if (difficulty ==400) {
			int randomNumber = rand.nextInt(breedIds400.size());
			breedId = breedIds400.get(randomNumber);
		} else if (difficulty ==500) {
			int randomNumber = rand.nextInt(breedIds500.size());
			breedId = breedIds500.get(randomNumber);
		} else if (difficulty ==600) {
			int randomNumber = rand.nextInt(breedIds600.size());
			breedId = breedIds600.get(randomNumber);
		} else if (difficulty ==800) {
			int randomNumber = rand.nextInt(breedIds800.size());
			breedId = breedIds800.get(randomNumber);
		} else {
			int randomNumber = rand.nextInt(breedIds1000.size());
			breedId = breedIds1000.get(randomNumber);
		}
		
		//use findBreed
		CatResponse res = findBreed(breedId);
		Card card = new Card();
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
		
		return card;
		
	}
	
	public Card generateBossCard() {
		
		List<String> bossBreeds = new ArrayList<>(Arrays.asList("sing","sava", "bomb", "amis", "sphy", "soma", "ebur",
				"toyg","orie", "ocic", "munc", "manx", "kuri", "beng", "tang", "snow", "siam", "bure", "tvan",
				"ycho","tonk", "jbob", "cymr", "ctiff", "bali"));

		String breedId = "";
		Random rand = new Random();
		
		int randomNumber = rand.nextInt(bossBreeds.size());
		breedId = bossBreeds.get(randomNumber);
		
		CatResponse res = findBreed(breedId);
		Card card = new Card();
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
		
		return card;
		
	}
	
	public CatResponse findCatInSpace() {
		
		String url = "https://api.thecatapi.com/v1/images/search?category_ids=2";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-api-key", catKey);
		
		
		CatResponse[] response = null;
		try {
 		response = rt.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), CatResponse[].class).getBody();
		} catch(RestClientException e) {
			System.out.println("Definition not found!");
		}
		
		CatResponse res = response[0];
		
		return res;
		
	}
	
	

}
