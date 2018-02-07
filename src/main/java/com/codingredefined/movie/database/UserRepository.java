package com.codingredefined.movie.database;

import org.springframework.data.repository.CrudRepository;

import com.codingredefined.movie.database.dto.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);
	
}
