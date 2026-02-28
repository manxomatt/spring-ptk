package com.ptk.domain.model.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * User domain entity.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "email", unique = true, length = 255)
    private String email;

    @Column(name = "phone", nullable = false, unique = true, length = 255)
    private String phone;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "avatar", length = 255)
    private String avatar;

    @Column(name = "url", length = 255)
    private String url;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "identity", length = 255)
    private String identity;

    @Column(name = "identity_image", columnDefinition = "TEXT")
    private String identityImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "activated_at")
    private LocalDateTime activatedAt;

    @Column(name = "activation_key", length = 255)
    private String activationKey;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "status_transaction_verified", nullable = false, length = 255)
    private String statusTransactionVerified;

    @Column(name = "transaction_success_count", nullable = false)
    private Integer transactionSuccessCount;

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

    @Column(name = "zip_code", length = 64)
    private String zipCode;

    @Column(name = "area_operational", length = 255)
    private String areaOperational;

    @Column(name = "sales_freq", columnDefinition = "TEXT")
    private String salesFreq;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "remember_token", length = 255)
    private String rememberToken;

    @Column(name = "last_location", length = 255)
    private String lastLocation;

    @Column(name = "latest_password")
    private LocalDateTime latestPassword;

    @Column(name = "latest_channel", nullable = false, length = 255)
    private String latestChannel;

    @Column(name = "bosnet_customer_id", columnDefinition = "TEXT")
    private String bosnetCustomerId;

    @Column(name = "category_user", length = 255)
    private String categoryUser;

    @Column(name = "store_address", columnDefinition = "TEXT")
    private String storeAddress;

    @Column(name = "api_key", length = 255)
    private String apiKey;

    @Column(name = "webhook_url", length = 255)
    private String webhookUrl;

    @Column(name = "api_ip_address", length = 255)
    private String apiIpAddress;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public enum Gender {
        pria, wanita
    }
}
