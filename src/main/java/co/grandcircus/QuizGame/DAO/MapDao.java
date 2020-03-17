package co.grandcircus.QuizGame.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.GameMap;


public interface MapDao extends JpaRepository<GameMap, Long>{

}
