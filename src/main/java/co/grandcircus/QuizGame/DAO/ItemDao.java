package co.grandcircus.QuizGame.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.Item;


public interface ItemDao extends JpaRepository<Item, Long> {

}
