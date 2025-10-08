package com.training.coforge.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.coforge.onlinebanking.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries here, for example:
    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
}
