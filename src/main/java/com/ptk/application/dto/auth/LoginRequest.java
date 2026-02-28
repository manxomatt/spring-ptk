package com.ptk.application.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * DTO for login request.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;
}
