package dev.akbayin.vokabeltrainerbackend.controllers;

import dev.akbayin.vokabeltrainerbackend.models.User;
import dev.akbayin.vokabeltrainerbackend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("users/create")
    public User createUser(User user) {
        userService.createUser(user);
        return user;
    }
}
