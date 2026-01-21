package com.taskmind.userservice.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String id;
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @Indexed(unique = true)
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password name is required")
    private String password;

    private UserPreferences preferences;

}