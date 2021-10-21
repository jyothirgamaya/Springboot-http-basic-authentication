package com.auth.repositry.jpa;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entity.User;

public interface UserRepo extends JpaRepository<User,Serializable> {

	Optional<User> findUserByName(String username);
 
}
