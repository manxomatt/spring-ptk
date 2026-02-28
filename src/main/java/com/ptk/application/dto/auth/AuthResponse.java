package com.ptk.application.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * DTO for authentication response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private Long expiresIn;

    private UserInfo user;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserInfo {
        private String id;
        private String username;
        private String roleId;
        private String grosirId;
        private String areaServiceId;
        private String status;
    }
}
