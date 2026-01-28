package com.taskmind.userservice.service;

import com.taskmind.userservice.dto.LoginRequest;
import com.taskmind.userservice.dto.UserRequest;
import com.taskmind.userservice.dto.UserResponse;
import com.taskmind.userservice.mapper.UserMapper;
import com.taskmind.userservice.model.User;
import com.taskmind.userservice.repository.UserRepository;
import com.taskmind.userservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;
    private final SequenceGeneratorService sequenceGeneratorService;
    private final JwtService jwtService;

    public UserResponse createUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists: " + request.getEmail());
        }
        User userRq = mapper.mapUserRequestToUser(request);
        userRq.setId(sequenceGeneratorService.generateSequence("users_sequence"));
        User userRs = userRepository.save(userRq);
        return mapper.mapUserToUserResponse(userRs);
    }

    public UserResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email or password");
        }

        //map response
        UserResponse userResponse = mapper.mapUserToUserResponse(user);

        //generate token and map it to the response
        String token = jwtService.generateToken(userResponse.getEmail(),userResponse.getId());
        userResponse.setToken(token);

        return userResponse;
    }
}