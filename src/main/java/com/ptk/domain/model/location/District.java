package com.ptk.domain.model.location;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * District domain entity.
 */
@Entity
@Table(name = "districts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class District implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "city_code", nullable = false, length = 255)
    private String cityCode;

    @Column(name = "county_code", nullable = false, unique = true, length = 255)
    private String countyCode;

    @Column(name = "county_name", nullable = false, length = 255)
    private String countyName;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
