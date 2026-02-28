package com.ptk.domain.model.partner;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * PartnerLog domain entity.
 */
@Entity
@Table(name = "partner_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerLog implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "motorist_id", nullable = false, length = 36)
    private String motoristId;

    @Column(name = "ip_address", columnDefinition = "TEXT")
    private String ipAddress;

    @Column(name = "end_point", columnDefinition = "TEXT")
    private String endPoint;

    @Column(name = "status_code", length = 255)
    private String statusCode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
