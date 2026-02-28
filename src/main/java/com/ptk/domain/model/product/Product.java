package com.ptk.domain.model.product;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Product domain entity representing a product in the system.
 * This entity maps to the existing 'products' table in the database.
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "code", nullable = false, length = 255)
    private String code;

    @Column(name = "brand_id", length = 36)
    private String brandId;

    @Column(name = "packtype_id", length = 36)
    private String packtypeId;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "name_to_display", length = 255)
    private String nameToDisplay;

    @Column(name = "carton_barcode", length = 255)
    private String cartonBarcode;

    @Column(name = "carton_image", length = 255)
    private String cartonImage;

    @Column(name = "pcs_barcode", length = 255)
    private String pcsBarcode;

    @Column(name = "pcs_image", length = 255)
    private String pcsImage;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Column(name = "image", length = 255)
    private String image;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "category1Id", length = 36)
    private String category1Id;

    @Column(name = "category2Id", length = 36)
    private String category2Id;

    @Column(name = "category3Id", length = 36)
    private String category3Id;

    @Column(name = "category4Id", length = 36)
    private String category4Id;

    @Column(name = "flagging_special_status", length = 255)
    private String flaggingSpecialStatus;

    @Column(name = "description", length = 255)
    private String description;

    /**
     * Domain method to check if product is active.
     */
    public boolean isActive() {
        return "active".equalsIgnoreCase(this.status) && this.deletedAt == null;
    }

    /**
     * Domain method to soft delete the product.
     */
    public void softDelete() {
        this.deletedAt = LocalDateTime.now();
    }
}
