package com.ptk.domain.model.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * UserBackoffice domain entity.
 */
@Entity
@Table(name = "user_backoffice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBackoffice implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role_id", nullable = false)
    private String roleId;

    @Column(name = "area_service_id")
    private String areaServiceId;

    @Column(name = "grosir_id", length = 36)
    private String grosirId;

    @Column(name = "status")
    private String status;

    @Column(name = "fcm_token")
    private String fcmToken;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
