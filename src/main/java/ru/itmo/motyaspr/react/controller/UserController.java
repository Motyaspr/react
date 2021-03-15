package ru.itmo.motyaspr.react.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itmo.motyaspr.react.model.User;
import ru.itmo.motyaspr.react.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("user")
class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void register(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

}