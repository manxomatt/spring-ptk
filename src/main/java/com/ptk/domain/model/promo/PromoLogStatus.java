package com.ptk.domain.model.promo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * PromoLogStatus domain entity.
 */
@Entity
@Table(name = "promo_logs_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromoLogStatus implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "promo_id", nullable = false, length = 36)
    private String promoId;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "description", length = 255)
    private String description;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
