package com.ptk.application.service.impl;

import com.ptk.application.dto.auth.AuthResponse;
import com.ptk.application.dto.auth.LoginRequest;
import com.ptk.application.dto.auth.RefreshTokenRequest;
import com.ptk.application.service.AuthService;
import com.ptk.infrastructure.security.JwtService;
import com.ptk.infrastructure.security.UserBackofficeDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Implementation of AuthService.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(LoginRequest request) {
        log.debug("Attempting login for user: {}", request.getUsername());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            UserBackofficeDetails userDetails = (UserBackofficeDetails) authentication.getPrincipal();
            
            String accessToken = jwtService.generateToken(userDetails);
            String refreshToken = jwtService.generateRefreshToken(userDetails);

            log.info("User {} logged in successfully", request.getUsername());

            return buildAuthResponse(userDetails, accessToken, refreshToken);

        } catch (AuthenticationException e) {
            log.warn("Login failed for user: {} - {}", request.getUsername(), e.getMessage());
            throw new BadCredentialsException("Invalid username or password");
        } catch (Exception e) {
            log.error("Unexpected error during login for user: {} - {}", request.getUsername(), e.getMessage(), e);
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest request) {
        log.debug("Attempting to refresh token");

        String refreshToken = request.getRefreshToken();
        String username = jwtService.extractUsername(refreshToken);

        if (username == null) {
            throw new BadCredentialsException("Invalid refresh token");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (!jwtService.isTokenValid(refreshToken, userDetails)) {
            throw new BadCredentialsException("Invalid or expired refresh token");
        }

        String newAccessToken = jwtService.generateToken(userDetails);
        String newRefreshToken = jwtService.generateRefreshToken(userDetails);

        log.info("Token refreshed successfully for user: {}", username);

        return buildAuthResponse((UserBackofficeDetails) userDetails, newAccessToken, newRefreshToken);
    }

    @Override
    public AuthResponse.UserInfo getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new BadCredentialsException("User not authenticated");
        }

        UserBackofficeDetails userDetails = (UserBackofficeDetails) authentication.getPrincipal();
        
        return AuthResponse.UserInfo.builder()
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .roleId(userDetails.getRoleId())
                .grosirId(userDetails.getGrosirId())
                .areaServiceId(userDetails.getAreaServiceId())
                .status(userDetails.getStatus())
                .build();
    }

    /**
     * Build AuthResponse from user details and tokens.
     */
    private AuthResponse buildAuthResponse(UserBackofficeDetails userDetails, String accessToken, String refreshToken) {
        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .expiresIn(jwtService.getJwtExpiration() / 1000) // Convert to seconds
                .user(AuthResponse.UserInfo.builder()
                        .id(userDetails.getId())
                        .username(userDetails.getUsername())
                        .roleId(userDetails.getRoleId())
                        .grosirId(userDetails.getGrosirId())
                        .areaServiceId(userDetails.getAreaServiceId())
                        .status(userDetails.getStatus())
                        .build())
                .build();
    }
}
