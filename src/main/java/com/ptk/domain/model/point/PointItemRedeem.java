package com.ptk.domain.model.point;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * PointItemRedeem domain entity.
 */
@Entity
@Table(name = "point_item_redeem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PointItemRedeem implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "item_name", nullable = false, length = 100)
    private String itemName;

    @Column(name = "banner", columnDefinition = "TEXT")
    private String banner;

    @Column(name = "point", nullable = false)
    private Double point;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "qty_remain")
    private Double qtyRemain;

    @Column(name = "type")
    private Integer type;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "short_description", length = 255)
    private String shortDescription;

    @Column(name = "status", length = 255)
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", nullable = false, length = 36)
    private String createdBy;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", nullable = false, length = 36)
    private String updatedBy;
}
