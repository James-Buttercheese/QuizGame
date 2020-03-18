package co.grandcircus.QuizGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.QuizGame.entities.User;

public interface UserRepo extends JpaRepository<User, Long>  {

}
