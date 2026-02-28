package com.ptk.domain.model.grosir;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * GrosirLogTransaction domain entity.
 */
@Entity
@Table(name = "grosir_log_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrosirLogTransaction implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "grosir_id", length = 36)
    private String grosirId;

    @Column(name = "activity", nullable = false, length = 255)
    private String activity;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
