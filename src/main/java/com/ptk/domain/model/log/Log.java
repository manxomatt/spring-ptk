package com.ptk.domain.model.log;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Log domain entity.
 */
@Entity
@Table(name = "logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;

    @Column(name = "activities", length = 255)
    private String activities;

    @Column(name = "activities_url", length = 255)
    private String activitiesUrl;

    @Column(name = "requests", columnDefinition = "TEXT")
    private String requests;

    @Column(name = "responses", columnDefinition = "TEXT")
    private String responses;

    @Column(name = "action_time", nullable = false)
    private LocalDateTime actionTime;
}
