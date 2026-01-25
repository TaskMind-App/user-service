package com.taskmind.userservice.service;

import com.taskmind.userservice.dto.UserRequest;
import com.taskmind.userservice.dto.UserResponse;
import com.taskmind.userservice.mapper.UserMapper;
import com.taskmind.userservice.model.User;
import com.taskmind.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserResponse createUser(UserRequest request) {
        User userRq = mapper.mapUserRequestToUser(request);
        User userRs = userRepository.save(userRq);
        return mapper.mapUserToUserResponse(userRs);
    }
}