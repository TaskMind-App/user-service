package com.taskmind.userservice.dto;

import com.taskmind.userservice.model.UserPreferences;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private UserPreferences preferences;
}