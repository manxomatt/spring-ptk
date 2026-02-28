package com.ptk.domain.model.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * UserPrincipal domain entity.
 */
@Entity
@Table(name = "user_principal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPrincipal implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

    @Column(name = "principal_id", nullable = false)
    private String principalId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role_id", nullable = false)
    private String roleId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
