package com.ptk.domain.model.grosir;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Grosir domain entity.
 */
@Entity
@Table(name = "grosirs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grosir implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "code", nullable = false, length = 255)
    private String code;

    @Column(name = "owner_name", length = 255)
    private String ownerName;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "area", nullable = false, length = 255)
    private String area;

    @Column(name = "area_service_id", length = 36)
    private String areaServiceId;

    @Column(name = "longitude", nullable = false, length = 255)
    private String longitude;

    @Column(name = "latitude", nullable = false, length = 255)
    private String latitude;

    @Column(name = "province_code", length = 255)
    private String provinceCode;

    @Column(name = "city_code", length = 255)
    private String cityCode;

    @Column(name = "district_code", length = 255)
    private String districtCode;

    @Column(name = "subdistrict_code", length = 255)
    private String subdistrictCode;

    @Column(name = "postal_code", length = 255)
    private String postalCode;

    @Column(name = "motorist_potency")
    private Integer motoristPotency;

    @Column(name = "avatar", length = 255)
    private String avatar;

    @Column(name = "credit_limit", nullable = false)
    private Integer creditLimit;

    @Column(name = "available_budget", nullable = false)
    private Integer availableBudget;

    @Column(name = "is_delivery")
    private Boolean isDelivery;

    @Column(name = "minimum_order_delivery")
    private Integer minimumOrderDelivery;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Column(name = "is_bnpl")
    private Boolean isBnpl;

    @Column(name = "type", nullable = false, length = 255)
    private String type;

    @Column(name = "npwp", length = 255)
    private String npwp;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
