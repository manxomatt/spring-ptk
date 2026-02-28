package com.ptk.domain.model.notification;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * CustomNotification domain entity.
 */
@Entity
@Table(name = "custom_notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomNotification implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "text", nullable = false, length = 255)
    private String text;

    @Column(name = "target_page", length = 255)
    private String targetPage;

    @Column(name = "target_id", length = 36)
    private String targetId;

    @Column(name = "send_total")
    private Integer sendTotal;

    @Column(name = "read_total")
    private Integer readTotal;

    @Column(name = "send_time", nullable = false)
    private LocalDateTime sendTime;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "target_group", length = 255)
    private String targetGroup;

    @Column(name = "target_group_id", length = 255)
    private String targetGroupId;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "created_by", length = 255)
    private String createdBy;
}
