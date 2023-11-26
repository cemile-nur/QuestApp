package com.project.questApp.services;

import com.project.questApp.entities.User;
import com.project.questApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User user) {
        return userRepository.save(user);
    }

    public User getOneUser(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(int userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setName(newUser.getName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else
            return null;
    }

    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }
}
