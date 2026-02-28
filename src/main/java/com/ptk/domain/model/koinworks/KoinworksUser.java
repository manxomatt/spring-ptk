package com.ptk.domain.model.koinworks;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * KoinworksUser domain entity.
 */
@Entity
@Table(name = "koinworks_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KoinworksUser implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;

    @Column(name = "koinworks_id", nullable = false)
    private Integer koinworksId;

    @Column(name = "koinworks_user_id", nullable = false)
    private Integer koinworksUserId;

    @Column(name = "user_email", length = 255)
    private String userEmail;

    @Column(name = "phone_number", length = 255)
    private String phoneNumber;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "available_amount")
    private Integer availableAmount;

    @Column(name = "reserve_amount")
    private Integer reserveAmount;

    @Column(name = "remaining_amount")
    private Integer remainingAmount;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "is_expired")
    private Integer isExpired;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "limit_status_value", length = 255)
    private String limitStatusValue;

    @Column(name = "contract_url", length = 500)
    private String contractUrl;

    @Column(name = "remarks", length = 255)
    private String remarks;

    @Column(name = "merchant_type", length = 255)
    private String merchantType;

    @Column(name = "access_token", columnDefinition = "TEXT")
    private String accessToken;

    @Column(name = "refresh_token", columnDefinition = "TEXT")
    private String refreshToken;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
