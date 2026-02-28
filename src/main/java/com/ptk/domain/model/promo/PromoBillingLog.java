package com.ptk.domain.model.promo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * PromoBillingLog domain entity.
 */
@Entity
@Table(name = "promo_billing_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromoBillingLog implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "promo_billing_id", nullable = false, length = 36)
    private String promoBillingId;

    @Column(name = "transaction_id", length = 255)
    private String transactionId;

    @Column(name = "transaction_status", length = 255)
    private String transactionStatus;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;

    @Column(name = "status_message", length = 255)
    private String statusMessage;

    @Column(name = "status_code", length = 255)
    private String statusCode;

    @Column(name = "data", columnDefinition = "JSON")
    private String data;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
