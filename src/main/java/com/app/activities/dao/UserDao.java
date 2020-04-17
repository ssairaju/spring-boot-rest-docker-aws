package com.app.activities.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.activities.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
