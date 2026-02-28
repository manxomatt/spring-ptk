package com.ptk.domain.model.challenge;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Challenger domain entity.
 */
@Entity
@Table(name = "challenger")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Challenger implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "challenge_id", nullable = false, length = 36)
    private String challengeId;

    @Column(name = "motorist_id", nullable = false, length = 36)
    private String motoristId;

    @Column(name = "target_achieved", nullable = false)
    private Double targetAchieved;

    @Column(name = "challenge_log", columnDefinition = "JSON")
    private String challengeLog;

    @Column(name = "status", nullable = false)
    private Integer status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
