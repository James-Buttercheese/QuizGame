package co.grandcircus.QuizGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
