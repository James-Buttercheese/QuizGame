package co.grandcircus.QuizGame.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.Pin;

public interface PinRepo extends JpaRepository<Pin, Long>  {

	List<Pin> findByMapId(Long id);
}
