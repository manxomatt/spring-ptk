package com.ptk.domain.model.motorist;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * MotoristDevice domain entity.
 */
@Entity
@Table(name = "motorist_devices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoristDevice implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "motorist_id", nullable = false, length = 36)
    private String motoristId;

    @Column(name = "device_id", length = 255)
    private String deviceId;

    @Column(name = "fcm_id", length = 255)
    private String fcmId;

    @Column(name = "device_token", length = 255)
    private String deviceToken;

    @Column(name = "login_count", nullable = false)
    private Integer loginCount;

    @Column(name = "longitude", length = 255)
    private String longitude;

    @Column(name = "latitude", length = 255)
    private String latitude;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
