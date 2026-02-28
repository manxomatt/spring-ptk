package com.ptk.domain.model.auth;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * AuthOtp domain entity.
 */
@Entity
@Table(name = "auth_otp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthOtp implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "user", nullable = false, length = 36)
    private String user;

    @Column(name = "activity", length = 100)
    private String activity;

    @Column(name = "otp", length = 255)
    private String otp;

    @Column(name = "channel", length = 255)
    private String channel;

    @Column(name = "expired", nullable = false)
    private LocalDateTime expired;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
