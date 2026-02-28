package com.ptk.domain.model.koinworks;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * KoinworksWizard domain entity.
 */
@Entity
@Table(name = "koinworks_wizard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KoinworksWizard implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;

    @Column(name = "checkpoint_type", length = 255)
    private String checkpointType;

    @Column(name = "status")
    private Integer status;

    @Column(name = "data", columnDefinition = "JSON")
    private String data;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
