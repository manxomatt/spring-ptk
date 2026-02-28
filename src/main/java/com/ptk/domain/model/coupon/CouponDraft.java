package com.ptk.domain.model.coupon;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * CouponDraft domain entity.
 */
@Entity
@Table(name = "coupon_drafts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponDraft implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "motorist_id", nullable = false, length = 36)
    private String motoristId;

    @Column(name = "name", columnDefinition = "TEXT")
    private String name;

    @Column(name = "transaction_type", length = 255)
    private String transactionType;

    @Column(name = "tenure", length = 36)
    private String tenure;

    @Column(name = "is_delivery")
    private Integer isDelivery;

    @Column(name = "payload", columnDefinition = "JSON")
    private String payload;

    @Column(name = "created_by", nullable = false, length = 36)
    private String createdBy;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
