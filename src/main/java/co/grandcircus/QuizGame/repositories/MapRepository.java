package co.grandcircus.QuizGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.Map;

public interface MapRepository extends JpaRepository<Map, Long> {

}
