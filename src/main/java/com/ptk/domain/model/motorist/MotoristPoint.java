package com.ptk.domain.model.motorist;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * MotoristPoint domain entity.
 */
@Entity
@Table(name = "motorist_points")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoristPoint implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "motorist_id", length = 36)
    private String motoristId;

    @Column(name = "source_id", length = 36)
    private String sourceId;

    @Column(name = "source", length = 255)
    private String source;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "expired_at", nullable = false)
    private LocalDateTime expiredAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "spending")
    private Integer spending;
}
