package com.ptk.domain.model.cart;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Cart Item domain entity.
 */
@Entity
@Table(name = "cart_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "cart_id", nullable = false, length = 36)
    private String cartId;

    @Column(name = "grosir_id", nullable = false, length = 36)
    private String grosirId;

    @Column(name = "promo_product_id", nullable = false, length = 36)
    private String promoProductId;

    @Column(name = "promo_product_pack_unit_id", length = 36)
    private String promoProductPackUnitId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
