package com.ptk.domain.model.area;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * AreaService domain entity.
 */
@Entity
@Table(name = "area_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaService implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "city_code", length = 255)
    private String cityCode;

    @Column(name = "transaction_limit")
    private Integer transactionLimit;

    @Column(name = "longitude", length = 255)
    private String longitude;

    @Column(name = "latitude", length = 255)
    private String latitude;

    @Column(name = "parent_id", length = 36)
    private String parentId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
