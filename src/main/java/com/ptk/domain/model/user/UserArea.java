package com.ptk.domain.model.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * UserArea domain entity - junction table for user and area relationship.
 */
@Entity
@Table(name = "user_area")
@IdClass(UserAreaId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserArea implements Serializable {

    @Id
    @Column(name = "user_id", length = 36)
    private String userId;

    @Id
    @Column(name = "area_id", length = 36)
    private String areaId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
