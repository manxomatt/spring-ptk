package com.ptk.domain.model.grosir;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * GrosirBanner domain entity.
 */
@Entity
@Table(name = "grosir_banner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrosirBanner implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "grosir_id", nullable = false, length = 36)
    private String grosirId;

    @Column(name = "banner_image", nullable = false, length = 255)
    private String bannerImage;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "created_by", nullable = false, length = 36)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
