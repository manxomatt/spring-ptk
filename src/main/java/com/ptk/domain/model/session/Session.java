package com.ptk.domain.model.session;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Session domain entity.
 */
@Entity
@Table(name = "sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Session implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "refresh_token", nullable = false, columnDefinition = "TEXT")
    private String refreshToken;

    @Column(name = "user_agent", nullable = false)
    private String userAgent;

    @Column(name = "client_ip", nullable = false)
    private String clientIp;

    @Column(name = "is_blocked", nullable = false)
    private Boolean isBlocked;

    @Column(name = "expires_at", nullable = false)
    private String expiresAt;

    @Column(name = "payload", length = 100)
    private String payload;

    @Column(name = "last_activity")
    private Integer lastActivity;

    @Column(name = "ip_address", length = 40)
    private String ipAddress;

    @Column(name = "user_id", length = 100)
    private String userId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
