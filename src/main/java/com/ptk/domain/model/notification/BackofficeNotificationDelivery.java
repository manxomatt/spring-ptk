package com.ptk.domain.model.notification;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BackofficeNotificationDelivery domain entity.
 */
@Entity
@Table(name = "backoffice_notification_delivery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(BackofficeNotificationDeliveryId.class)
public class BackofficeNotificationDelivery implements Serializable {

    @Id
    @Column(name = "notification_id", length = 36)
    private String notificationId;

    @Id
    @Column(name = "user_id", length = 36)
    private String userId;

    @Column(name = "read_at")
    private LocalDateTime readAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
