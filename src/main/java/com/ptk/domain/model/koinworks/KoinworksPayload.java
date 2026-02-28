package com.ptk.domain.model.koinworks;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * KoinworksPayload domain entity.
 */
@Entity
@Table(name = "koinworks_payload")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KoinworksPayload implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;

    @Column(name = "payload", columnDefinition = "TEXT")
    private String payload;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
