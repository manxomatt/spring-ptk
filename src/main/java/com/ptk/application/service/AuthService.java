package com.ptk.application.service;

import com.ptk.application.dto.auth.AuthResponse;
import com.ptk.application.dto.auth.LoginRequest;
import com.ptk.application.dto.auth.RefreshTokenRequest;

/**
 * Service interface for authentication operations.
 */
public interface AuthService {

    /**
     * Authenticate user and generate tokens.
     */
    AuthResponse login(LoginRequest request);

    /**
     * Refresh access token using refresh token.
     */
    AuthResponse refreshToken(RefreshTokenRequest request);

    /**
     * Get current authenticated user info.
     */
    AuthResponse.UserInfo getCurrentUser();
}
