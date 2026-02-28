package com.ptk.domain.model.quote;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Quote domain entity.
 */
@Entity
@Table(name = "quotes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "quotes", columnDefinition = "TEXT")
    private String quotes;

    @Column(name = "created_by", nullable = false, length = 36)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
