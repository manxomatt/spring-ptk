package com.ptk.domain.model.warung;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Warung domain entity.
 */
@Entity
@Table(name = "warungs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warung implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "owner", length = 255)
    private String owner;

    @Column(name = "avatar", length = 255)
    private String avatar;

    @Column(name = "slug", length = 255)
    private String slug;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "province_code", length = 255)
    private String provinceCode;

    @Column(name = "city_code", length = 255)
    private String cityCode;

    @Column(name = "district_code", length = 255)
    private String districtCode;

    @Column(name = "subdistrict_code", length = 255)
    private String subdistrictCode;

    @Column(name = "latitude", length = 255)
    private String latitude;

    @Column(name = "longitude", length = 255)
    private String longitude;

    @Column(name = "areas", length = 255)
    private String areas;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "is_retail", nullable = false)
    private Boolean isRetail;

    @Column(name = "input_by", nullable = false, length = 36)
    private String inputBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
