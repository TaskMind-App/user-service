package com.taskmind.userservice.mapper;

import com.taskmind.userservice.dto.UserResponse;
import com.taskmind.userservice.dto.UserRequest;
import com.taskmind.userservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserResponse mapUserToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .preferences(user.getPreferences())
                .build();
    }

    public User mapUserRequestToUser(UserRequest request){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .preferences(request.getPreferences())
                .build();
    }
}
