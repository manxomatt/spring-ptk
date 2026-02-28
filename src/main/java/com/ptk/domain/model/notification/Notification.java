package com.ptk.domain.model.notification;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Notification domain entity.
 */
@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "motorist_id", nullable = false, length = 36)
    private String motoristId;

    @Column(name = "source_id", length = 36)
    private String sourceId;

    @Column(name = "source", length = 255)
    private String source;

    @Column(name = "owner", columnDefinition = "JSON")
    private String owner;

    @Column(name = "activity", length = 255)
    private String activity;

    @Column(name = "data", columnDefinition = "JSON")
    private String data;

    @Column(name = "link", length = 255)
    private String link;

    @Column(name = "read_at")
    private LocalDateTime readAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
