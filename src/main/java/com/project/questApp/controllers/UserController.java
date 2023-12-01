package com.project.questApp.controllers;

import com.project.questApp.entities.User;
import com.project.questApp.repository.UserRepository;
import com.project.questApp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public  User createUser(@RequestBody User user){
        return userService.saveOneUser(user);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable int userId){
        //custom exception
        return userService.getOneUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable int userId, @RequestBody User newUser){
        return userService.updateOneUser(userId,newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable int userId){
        userService.deleteById(userId);
    }

}
