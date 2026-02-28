package com.ptk.domain.model.inventory;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Inventory Product domain entity.
 */
@Entity
@Table(name = "inventory_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryProduct implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "inventory_id", nullable = false, length = 36)
    private String inventoryId;

    @Column(name = "product_id", nullable = false, length = 36)
    private String productId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
