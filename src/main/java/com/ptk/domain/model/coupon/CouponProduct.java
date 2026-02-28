package com.ptk.domain.model.coupon;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * CouponProduct domain entity.
 */
@Entity
@Table(name = "coupon_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponProduct implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "coupon_id", nullable = false, length = 36)
    private String couponId;

    @Column(name = "promo_product_id", nullable = false, length = 36)
    private String promoProductId;

    @Column(name = "promo_product_pack_unit_id", length = 36)
    private String promoProductPackUnitId;

    @Column(name = "before_price", nullable = false)
    private Double beforePrice;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @Column(name = "comp_percent", nullable = false)
    private Integer compPercent;

    @Column(name = "claim_grosir", nullable = false)
    private Double claimGrosir;

    @Column(name = "total_save", nullable = false)
    private Double totalSave;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "type", columnDefinition = "TEXT")
    private String type;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "product_id", nullable = false, length = 36)
    private String productId;
}
