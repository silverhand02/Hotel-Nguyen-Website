package com.finalproject.nguyen22.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.finalproject.nguyen22.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("Select u from User u where u.username = ?1")
	public User findByUsername(@Param("username") String username);

	
	@Query("Select u from User u where u.phone = ?1")
	public User findByPhone(@Param("phone") String phone);
	
	@Query("Select u from User u where u.email = ?1")
	public User findByEmail(@Param("email") String email);
	

}
