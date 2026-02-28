package com.ptk.domain.model.log;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * LogCoupon domain entity.
 */
@Entity
@Table(name = "log_coupons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogCoupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "coupon_id", length = 36)
    private String couponId;

    @Column(name = "total_product")
    private Double totalProduct;

    @Column(name = "total_price")
    private Double totalPrice;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
