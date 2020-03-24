package co.grandcircus.QuizGame.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.User;

public interface UserRepo extends JpaRepository<User, Long>  {
	
	User findByUsername(String username);
	
	List<User> findByOrderByWinsDesc();
	List<User> findByOrderByPlayedDesc();
	List<User> findByOrderByScoreDesc();

}
