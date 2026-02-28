package com.ptk.domain.model.promo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Promo Product domain entity.
 */
@Entity
@Table(name = "promo_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromoProduct implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "promo_id", nullable = false, length = 36)
    private String promoId;

    @Column(name = "product_id", nullable = false, length = 36)
    private String productId;

    @Column(name = "product_packtype_id", length = 36)
    private String productPacktypeId;

    @Column(name = "checked")
    private Boolean checked;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "price_before", nullable = false)
    private Integer priceBefore;

    @Column(name = "comp_grosir", nullable = false)
    private Float compGrosir;

    @Column(name = "price_grosir", nullable = false)
    private Float priceGrosir;

    @Column(name = "comp_motorist", nullable = false)
    private Float compMotorist;

    @Column(name = "price_motorist", nullable = false)
    private Float priceMotorist;

    @Column(name = "comp_percent", nullable = false)
    private Integer compPercent;

    @Column(name = "price_comp", nullable = false)
    private Integer priceComp;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "quantity_left", nullable = false)
    private Integer quantityLeft;

    @Column(name = "quantity_remain", nullable = false)
    private Integer quantityRemain;

    @Column(name = "price_buy", nullable = false)
    private Integer priceBuy;

    @Column(name = "subtotal", nullable = false)
    private Integer subtotal;

    @Column(name = "subtotal_before", nullable = false)
    private Integer subtotalBefore;

    @Column(name = "subtotal_grosir", nullable = false)
    private Integer subtotalGrosir;

    @Column(name = "subtotal_motorist", nullable = false)
    private Integer subtotalMotorist;

    @Column(name = "subtotal_save", nullable = false)
    private Integer subtotalSave;

    @Column(name = "comp_type", length = 255)
    private String compType;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
