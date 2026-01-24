package com.taskmind.userservice.service;

import com.taskmind.userservice.dto.UserRequest;
import com.taskmind.userservice.model.User;
import com.taskmind.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(UserRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .preferences(request.getPreferences())
                .build();

        return userRepository.save(user);
    }
}