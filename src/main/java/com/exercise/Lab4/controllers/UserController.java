package com.exercise.Lab4.controllers;

import com.exercise.Lab4.aspect.annotation.ExecutionTime;
import com.exercise.Lab4.domain.Post;
import com.exercise.Lab4.domain.User;
import com.exercise.Lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public User findUserById(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> findUserPosts(@PathVariable("id") long id) {
        return userService.findUserPosts(id);
    }

}
