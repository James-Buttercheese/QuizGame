package co.grandcircus.QuizGame.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.GameMap;

public interface GameMapRepo extends JpaRepository<GameMap, Long> {
	
	List<GameMap> findByUserId(Long id);

}
