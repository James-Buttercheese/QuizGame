package co.grandcircus.QuizGame.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.Pin;


public interface PinDao extends JpaRepository<Pin, Long>{

}
