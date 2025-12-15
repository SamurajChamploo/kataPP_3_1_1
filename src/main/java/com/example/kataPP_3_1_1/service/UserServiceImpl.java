package com.example.kataPP_3_1_1.service;

import com.example.kataPP_3_1_1.model.User;
import com.example.kataPP_3_1_1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, String firstName, String lastName, String email, Integer age, String city) {
        User existingUser = getUserById(id);

        existingUser.setFirstName(firstName);
        existingUser.setLastName(lastName);
        existingUser.setEmail(email);
        existingUser.setAge(age);
        existingUser.setCity(city);

        saveUser(existingUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }
}
