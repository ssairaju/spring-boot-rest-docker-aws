package com.app.activities.service;

import java.util.List;

import com.app.activities.model.User;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    List<User> findAll();
    User getUserById(long id);
    void deleteUser(long id);
}
