package com.singha.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singha.app.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	Optional<User> findByUserid(String userid);

}
