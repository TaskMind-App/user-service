package com.taskmind.userservice.controller;

import com.taskmind.userservice.dto.UserRequest;
import com.taskmind.userservice.dto.UserResponse;
import com.taskmind.userservice.model.User;
import com.taskmind.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse registerUser(@Valid @RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}