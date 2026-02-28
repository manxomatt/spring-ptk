package com.ptk.domain.model.location;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * City domain entity.
 */
@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "province_code", nullable = false, length = 255)
    private String provinceCode;

    @Column(name = "city_code", nullable = false, unique = true, length = 255)
    private String cityCode;

    @Column(name = "city_name", nullable = false, length = 255)
    private String cityName;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
