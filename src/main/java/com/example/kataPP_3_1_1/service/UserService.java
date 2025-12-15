package com.example.kataPP_3_1_1.service;

import com.example.kataPP_3_1_1.model.User;
import com.example.kataPP_3_1_1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, String firstName, String lastName, String email, Integer age, String city) {
        User existingUser = getUserById(id);

        existingUser.setFirstName(firstName);
        existingUser.setLastName(lastName);
        existingUser.setEmail(email);
        existingUser.setAge(age);
        existingUser.setCity(city);

        saveUser(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }
}
