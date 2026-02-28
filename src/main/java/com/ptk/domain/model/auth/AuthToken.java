package com.ptk.domain.model.auth;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * AuthToken domain entity.
 */
@Entity
@Table(name = "auth_token")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthToken implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "user", length = 36)
    private String user;

    @Column(name = "hash", nullable = false, length = 255)
    private String hash;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
