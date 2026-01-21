package com.taskmind.userservice.service;

import com.taskmind.userservice.dto.UserRequest;
import com.taskmind.userservice.model.User;
import com.taskmind.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .preferences(request.getPreferences())
                .build();

        return userRepository.save(user);
    }
}