package com.finalproject.nguyen22.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.nguyen22.entity.User;
import com.finalproject.nguyen22.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepo;
	
	public List<User> getAll(){
		return userRepo.findAll();
	}
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public User findByUsername(String username) {
		User result = userRepo.findByUsername(username);
		return result;
	}
	
	public User findByEmail(String email) {
		User result = userRepo.findByEmail(email);
		return result;
	}
	
	public User findByPhone(String phone) {
		User result = userRepo.findByPhone(phone);
		return result;
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
}
