package com.ptk.domain.model.challenge;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Challenge domain entity.
 */
@Entity
@Table(name = "challenge")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Challenge implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "subject", length = 255)
    private String subject;

    @Column(name = "subtitle", length = 255)
    private String subtitle;

    @Column(name = "activity", length = 255)
    private String activity;

    @Column(name = "activity_target", nullable = false)
    private Integer activityTarget;

    @Column(name = "activity_point", nullable = false)
    private Double activityPoint;

    @Column(name = "data", columnDefinition = "JSON")
    private String data;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "link", length = 255)
    private String link;

    @Column(name = "created_by", nullable = false, length = 36)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "expired_at", nullable = false)
    private LocalDateTime expiredAt;

    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt;
}
