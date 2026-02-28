package com.ptk.domain.model.location;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Province domain entity.
 */
@Entity
@Table(name = "provinces")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Province implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "province_code", nullable = false, unique = true, length = 255)
    private String provinceCode;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "country_id", length = 255)
    private String countryId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
