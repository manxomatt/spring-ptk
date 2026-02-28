package com.ptk.domain.model.category;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Category Level 1 domain entity.
 */
@Entity
@Table(name = "categories_lv1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryLv1 implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code", nullable = false, length = 255)
    private String code;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "icon", length = 255)
    private String icon;

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
