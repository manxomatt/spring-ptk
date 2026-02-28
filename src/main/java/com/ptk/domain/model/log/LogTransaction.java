package com.ptk.domain.model.log;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * LogTransaction domain entity.
 */
@Entity
@Table(name = "logs_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogTransaction implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "coupon_id", nullable = false, length = 36)
    private String couponId;

    @Column(name = "available", nullable = false)
    private Integer available;

    @Column(name = "booked", nullable = false)
    private Integer booked;

    @Column(name = "remain", nullable = false)
    private Integer remain;

    @Column(name = "qty_promo_product", nullable = false)
    private Integer qtyPromoProduct;

    @Column(name = "event_type", nullable = false, length = 255)
    private String eventType;

    @Column(name = "promo_product_id", nullable = false, length = 36)
    private String promoProductId;

    @Column(name = "motorist_id", nullable = false, length = 36)
    private String motoristId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
