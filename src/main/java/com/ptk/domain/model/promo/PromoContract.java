package com.ptk.domain.model.promo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * PromoContract domain entity.
 */
@Entity
@Table(name = "promo_contracts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromoContract implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "promo_id", nullable = false, length = 36)
    private String promoId;

    @Column(name = "filename", nullable = false, length = 255)
    private String filename;

    @Column(name = "attachment", nullable = false, length = 255)
    private String attachment;

    @Column(name = "uploaded_by", length = 255)
    private String uploadedBy;

    @Column(name = "with_confirm")
    private Boolean withConfirm;

    @Column(name = "process_id", length = 36)
    private String processId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
