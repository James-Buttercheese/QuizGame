package co.grandcircus.QuizGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import co.grandcircus.QuizGame.entities.GameMap;

public interface MapRepository extends JpaRepository<GameMap, Long> {
}