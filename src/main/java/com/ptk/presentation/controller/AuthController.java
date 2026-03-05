package com.ptk.presentation.controller;

import com.ptk.application.dto.auth.AuthResponse;
import com.ptk.application.dto.auth.LoginRequest;
import com.ptk.application.dto.auth.RefreshTokenRequest;
import com.ptk.application.dto.common.ApiResponse;
import com.ptk.application.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for authentication operations.
 */
@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication APIs")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Authenticate user and get JWT tokens")
    public ResponseEntity<ApiResponse<AuthResponse>> login(
            @Valid @RequestBody LoginRequest request) {
        
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(ApiResponse.success(response, "Login successful"));
    }

    @PostMapping("/refresh")
    @Operation(summary = "Refresh Token", description = "Refresh access token using refresh token")
    public ResponseEntity<ApiResponse<AuthResponse>> refreshToken(
            @Valid @RequestBody RefreshTokenRequest request) {
        
        AuthResponse response = authService.refreshToken(request);
        return ResponseEntity.ok(ApiResponse.success(response, "Token refreshed successfully"));
    }

    @GetMapping("/me")
    @Operation(summary = "Get Current User", description = "Get current authenticated user information")
    public ResponseEntity<ApiResponse<AuthResponse.UserInfo>> getCurrentUser() {
        
        AuthResponse.UserInfo userInfo = authService.getCurrentUser();
        return ResponseEntity.ok(ApiResponse.success(userInfo, "User info retrieved successfully"));
    }
}
