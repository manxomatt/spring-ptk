package com.ptk.domain.model.checkpoint;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Checkpoint domain entity.
 */
@Entity
@Table(name = "checkpoint")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Checkpoint implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;

    @Column(name = "grosir_id", length = 36)
    private String grosirId;

    @Column(name = "checkpoint_type", length = 255)
    private String checkpointType;

    @Column(name = "step")
    private Integer step;

    @Column(name = "checkpoint_data", columnDefinition = "JSON")
    private String checkpointData;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
