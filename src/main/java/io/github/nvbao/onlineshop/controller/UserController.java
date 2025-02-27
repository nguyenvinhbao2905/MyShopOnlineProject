package io.github.nvbao.onlineshop.controller;


import io.github.nvbao.onlineshop.dto.request.user.UserCreationRequest;
import io.github.nvbao.onlineshop.entity.usermanager.User;
import io.github.nvbao.onlineshop.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    Optional<User> getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

//    @PutMapping("/{userId}")
//    Optional<User> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
//        return userService.updateUser(userId, request);
//    }

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
