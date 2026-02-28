package com.ptk.domain.model.principal;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Principal domain entity.
 */
@Entity
@Table(name = "principals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Principal implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code", nullable = false, length = 255)
    private String code;

    @Column(name = "name", nullable = false, unique = true, length = 255)
    private String name;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "dwh_id", length = 255)
    private String dwhId;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "contact", nullable = false, length = 255)
    private String contact;

    @Column(name = "mobile_phone", nullable = false, length = 255)
    private String mobilePhone;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
