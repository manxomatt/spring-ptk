package com.ptk.domain.model.promo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Promo domain entity.
 */
@Entity
@Table(name = "promos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Promo implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "grosir_id", nullable = false, length = 36)
    private String grosirId;

    @Column(name = "inventory_checking_id", length = 36)
    private String inventoryCheckingId;

    @Column(name = "code", nullable = false, length = 255)
    private String code;

    @Column(name = "budget", nullable = false)
    private Integer budget;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Column(name = "revision")
    private Integer revision;

    @Column(name = "created_by", nullable = false, length = 36)
    private String createdBy;

    @Column(name = "created_by_role", length = 255)
    private String createdByRole;

    @Column(name = "note", columnDefinition = "JSON")
    private String note;

    @Column(name = "note_manager", columnDefinition = "JSON")
    private String noteManager;

    @Column(name = "note_grosir", columnDefinition = "JSON")
    private String noteGrosir;

    @Column(name = "note_by_system", length = 255)
    private String noteBySystem;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
