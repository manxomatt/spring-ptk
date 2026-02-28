package com.ptk.domain.model.location;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Subdistrict domain entity.
 */
@Entity
@Table(name = "subdistricts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subdistrict implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "county_code", nullable = false, length = 255)
    private String countyCode;

    @Column(name = "subcounty_code", nullable = false, unique = true, length = 255)
    private String subcountyCode;

    @Column(name = "subcounty_name", nullable = false, length = 255)
    private String subcountyName;

    @Column(name = "zip_code", nullable = false, length = 255)
    private String zipCode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
