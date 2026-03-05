package com.ptk.domain.model.brand;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Brand domain entity.
 */
@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code", nullable = false, length = 255)
    private String code;

    @Column(name = "name", nullable = false, unique = true, length = 255)
    private String name;

    @Column(name = "principal_id", length = 36)
    private String principalId;

    @Column(name = "category1_id", length = 36)
    private String category1Id;

    @Column(name = "category2_id", length = 36)
    private String category2Id;

    @Column(name = "category3_id", length = 36)
    private String category3Id;

    @Column(name = "category4_id", length = 36)
    private String category4Id;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "integrated")
    private Boolean integrated;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
