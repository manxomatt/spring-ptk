package com.ptk.domain.model.site;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * SiteOption domain entity.
 */
@Entity
@Table(name = "site_options")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SiteOption implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "site_value", columnDefinition = "TEXT")
    private String siteValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "site_type")
    private SiteType siteType;

    @Column(name = "autoload", nullable = false)
    private Boolean autoload;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public enum SiteType {
        text, date, bool, file, @SuppressWarnings("java:S115") double_
    }
}
