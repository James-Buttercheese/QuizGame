package co.grandcircus.QuizGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
