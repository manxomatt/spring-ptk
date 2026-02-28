package com.ptk.application.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * DTO for refresh token request.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshTokenRequest {

    @NotBlank(message = "Refresh token is required")
    @JsonProperty("refresh_token")
    private String refreshToken;
}
