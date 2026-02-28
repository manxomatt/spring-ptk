package com.ptk.domain.model.inventory;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Inventory domain entity.
 */
@Entity
@Table(name = "inventories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "grosir_id", nullable = false, length = 36)
    private String grosirId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
