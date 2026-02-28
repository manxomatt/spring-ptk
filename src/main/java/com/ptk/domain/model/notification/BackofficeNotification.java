package com.ptk.domain.model.notification;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BackofficeNotification domain entity.
 */
@Entity
@Table(name = "backoffice_notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BackofficeNotification implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "message_type", length = 255)
    private String messageType;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "subtitle", length = 255)
    private String subtitle;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "user_groups", length = 255)
    private String userGroups;

    @Column(name = "area_ids", length = 255)
    private String areaIds;

    @Column(name = "grosir_ids", length = 255)
    private String grosirIds;

    @Column(name = "city_ids", length = 255)
    private String cityIds;

    @Column(name = "broadcast_type", length = 255)
    private String broadcastType;

    @Column(name = "broadcast_schedule")
    private LocalDateTime broadcastSchedule;

    @Column(name = "send_status", length = 255)
    private String sendStatus;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "created_by", length = 255)
    private String createdBy;
}
