package com.ptk.domain.model.fcm;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * FcmTopic domain entity.
 */
@Entity
@Table(name = "fcm_topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FcmTopic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fcm_id", nullable = false, length = 255)
    private String fcmId;

    @Column(name = "topics", nullable = false, length = 255)
    private String topics;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
