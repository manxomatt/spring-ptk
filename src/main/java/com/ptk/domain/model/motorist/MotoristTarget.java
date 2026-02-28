package com.ptk.domain.model.motorist;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * MotoristTarget domain entity.
 */
@Entity
@Table(name = "motorist_target")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoristTarget implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "motorist_id", length = 36)
    private String motoristId;

    @Column(name = "target_month", nullable = false, length = 255)
    private String targetMonth;

    @Column(name = "target_amount", nullable = false)
    private Double targetAmount;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
