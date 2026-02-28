package com.ptk.domain.model.notification;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * NotificationReadReceipt domain entity.
 */
@Entity
@Table(name = "notification_read_receipt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationReadReceipt implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "notification_id", length = 36)
    private String notificationId;

    @Column(name = "user_id", length = 36)
    private String userId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
