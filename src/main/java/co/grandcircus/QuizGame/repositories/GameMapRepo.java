package co.grandcircus.QuizGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.GameMap;

public interface GameMapRepo extends JpaRepository<GameMap, Long> {

}
