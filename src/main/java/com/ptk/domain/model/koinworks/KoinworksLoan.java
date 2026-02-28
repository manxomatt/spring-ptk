package com.ptk.domain.model.koinworks;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * KoinworksLoan domain entity.
 */
@Entity
@Table(name = "koinworks_loans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KoinworksLoan implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;

    @Column(name = "coupon_id", nullable = false, length = 36)
    private String couponId;

    @Column(name = "koinworks_loan_id", nullable = false)
    private Integer koinworksLoanId;

    @Column(name = "koinworks_user_id", nullable = false)
    private Integer koinworksUserId;

    @Column(name = "disbursement_date")
    private LocalDateTime disbursementDate;

    @Column(name = "loan_amount")
    private Integer loanAmount;

    @Column(name = "disbursed_amount")
    private Integer disbursedAmount;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "day_past_due")
    private Integer dayPastDue;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "interest")
    private Integer interest;

    @Column(name = "late_fee")
    private Integer lateFee;

    @Column(name = "principal")
    private Integer principal;

    @Column(name = "total_out_standing")
    private Integer totalOutStanding;

    @Column(name = "other_fee")
    private Integer otherFee;

    @Column(name = "vat_amount")
    private Integer vatAmount;

    @Column(name = "platform_fee_amount")
    private Integer platformFeeAmount;

    @Column(name = "platform_fee_rate")
    private Integer platformFeeRate;

    @Column(name = "loan_status", length = 255)
    private String loanStatus;

    @Column(name = "loan_status_value", length = 255)
    private String loanStatusValue;

    @Column(name = "tenure")
    private Integer tenure;

    @Column(name = "tenure_unit", length = 255)
    private String tenureUnit;

    @Column(name = "bnpl_vendor", length = 255)
    private String bnplVendor;

    @Column(name = "has_otp")
    private Integer hasOtp;

    @Column(name = "otp_at")
    private LocalDateTime otpAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
