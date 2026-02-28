package com.ptk.domain.model.notification;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * CustomNotificationLog domain entity.
 */
@Entity
@Table(name = "custom_notification_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomNotificationLog implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "total_entries_affected")
    private Integer totalEntriesAffected;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
