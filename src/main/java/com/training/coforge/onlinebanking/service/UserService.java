package com.training.coforge.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.coforge.onlinebanking.model.User;
import com.training.coforge.onlinebanking.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {


	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


	// Save new user with hashed password
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	// Login method
	public boolean login(String email, String rawPassword) {
		User user = userRepository.findByEmail(email);
		if (user == null) return false;

		return passwordEncoder.matches(rawPassword, user.getPassword());
	}

	// Get all users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Get user by ID
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	// Delete user
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
