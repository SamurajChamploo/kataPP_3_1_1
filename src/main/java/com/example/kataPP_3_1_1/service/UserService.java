package com.example.kataPP_3_1_1.service;

import com.example.kataPP_3_1_1.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void saveUser(User user);

    void updateUser(Long id, String firstName, String lastName, String email, Integer age, String city);

    void deleteUser(Long id);
}
