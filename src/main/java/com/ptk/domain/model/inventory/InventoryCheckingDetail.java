package com.ptk.domain.model.inventory;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * InventoryCheckingDetail domain entity.
 */
@Entity
@Table(name = "inventory_checking_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryCheckingDetail implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "checker_id", length = 36)
    private String checkerId;

    @Column(name = "sku_id", length = 36)
    private String skuId;

    @Column(name = "product_packtype_id", length = 36)
    private String productPacktypeId;

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @Column(name = "buy_price", nullable = false)
    private Integer buyPrice;

    @Column(name = "sell_price", nullable = false)
    private Integer sellPrice;

    @Column(name = "supplier", length = 255)
    private String supplier;

    @Column(name = "goods_condition", nullable = false, length = 255)
    private String goodsCondition;

    @Column(name = "incoming_goods")
    private Integer incomingGoods;

    @Column(name = "incoming_goods_date")
    private LocalDate incomingGoodsDate;

    @Column(name = "near_expire", nullable = false)
    private LocalDate nearExpire;

    @Column(name = "near_expire_image", length = 255)
    private String nearExpireImage;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "inventory_checking_id", nullable = false, length = 255)
    private String inventoryCheckingId;
}
