package com.ptk.domain.model.inventory;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * InventoryChecking domain entity.
 */
@Entity
@Table(name = "inventory_checkings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryChecking implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "grosir_id", length = 36)
    private String grosirId;

    @Column(name = "submitted_date")
    private LocalDate submittedDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Column(name = "checker_id", length = 36)
    private String checkerId;
}
