package com.ptk.domain.model.promo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * SaasPromo domain entity.
 */
@Entity
@Table(name = "saas_promos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaasPromo implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "grosir_id", nullable = false, length = 36)
    private String grosirId;

    @Column(name = "inventory_checking_id", nullable = false, length = 36)
    private String inventoryCheckingId;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "status")
    private String status;

    @Column(name = "revision")
    private Integer revision;

    @Column(name = "type")
    private String type;

    @Column(name = "created_by", length = 36)
    private String createdBy;

    @Column(name = "created_by_role")
    private String createdByRole;

    @Column(name = "note", columnDefinition = "JSON")
    private String note;

    @Column(name = "note_manager", columnDefinition = "JSON")
    private String noteManager;

    @Column(name = "note_grosir", columnDefinition = "JSON")
    private String noteGrosir;

    @Column(name = "note_by_system")
    private String noteBySystem;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
