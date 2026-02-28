package com.ptk.domain.model.banner;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Banner domain entity.
 */
@Entity
@Table(name = "banner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Banner implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "banner_type")
    private Integer bannerType;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "subject", nullable = false, length = 255)
    private String subject;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "activity", nullable = false, length = 255)
    private String activity;

    @Column(name = "`order`", nullable = false)
    private Integer order;

    @Column(name = "destination", columnDefinition = "TEXT")
    private String destination;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "created_by", nullable = false, length = 36)
    private String createdBy;

    @Column(name = "area", columnDefinition = "TEXT")
    private String area;

    @Column(name = "opened")
    private Integer opened;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
