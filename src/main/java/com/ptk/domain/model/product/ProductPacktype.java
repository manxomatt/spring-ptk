package com.ptk.domain.model.product;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ProductPacktype domain entity.
 */
@Entity
@Table(name = "product_packtype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPacktype implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "product_id", nullable = false, length = 36)
    private String productId;

    @Column(name = "packtype_id", nullable = false, length = 36)
    private String packtypeId;

    @Column(name = "conversion")
    private Integer conversion;

    @Column(name = "is_show")
    private Integer isShow;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
