package com.ptk.domain.model.grosir;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * GrosirBnpl domain entity.
 */
@Entity
@Table(name = "grosir_bnpls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrosirBnpl implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "grosir_id", nullable = false, length = 36)
    private String grosirId;

    @Column(name = "distributor_id", length = 255)
    private String distributorId;

    @Column(name = "bank_code", nullable = false, length = 255)
    private String bankCode;

    @Column(name = "bank_account_number", nullable = false, length = 255)
    private String bankAccountNumber;

    @Column(name = "bank_account_name", nullable = false, length = 255)
    private String bankAccountName;

    @Column(name = "bank_branch_name", length = 255)
    private String bankBranchName;

    @Column(name = "bnpl_vendor", length = 255)
    private String bnplVendor;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
