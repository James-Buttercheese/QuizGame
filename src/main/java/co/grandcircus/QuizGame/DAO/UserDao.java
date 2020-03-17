package co.grandcircus.QuizGame.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.User;


public interface UserDao extends JpaRepository<User, Long>{

}
