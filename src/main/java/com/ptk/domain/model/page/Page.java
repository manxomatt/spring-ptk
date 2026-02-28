package com.ptk.domain.model.page;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Page domain entity.
 */
@Entity
@Table(name = "pages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Page implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "slug", nullable = false, length = 255)
    private String slug;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "created_by", nullable = false, length = 36)
    private String createdBy;

    @Column(name = "updated_by", length = 36)
    private String updatedBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
