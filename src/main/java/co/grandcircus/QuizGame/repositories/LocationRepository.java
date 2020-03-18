package co.grandcircus.QuizGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import co.grandcircus.QuizGame.entities.Pin;

public interface LocationRepository extends JpaRepository<Pin, Long> {
}