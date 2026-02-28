package com.ptk.domain.model.promo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * PromoBilling domain entity.
 */
@Entity
@Table(name = "promo_billings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromoBilling implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "promo_id", nullable = false, length = 36)
    private String promoId;

    @Column(name = "order_id", length = 36)
    private String orderId;

    @Column(name = "base_amount", nullable = false)
    private Double baseAmount;

    @Column(name = "platform_fee")
    private Double platformFee;

    @Column(name = "ppn_fee")
    private Double ppnFee;

    @Column(name = "pph_fee")
    private Double pphFee;

    @Column(name = "vendor_fee")
    private Double vendorFee;

    @Column(name = "total_fee")
    private Double totalFee;

    @Column(name = "invoice_date")
    private LocalDateTime invoiceDate;

    @Column(name = "expired_date")
    private LocalDateTime expiredDate;

    @Column(name = "settlement_date")
    private LocalDateTime settlementDate;

    @Column(name = "payment_type", length = 255)
    private String paymentType;

    @Column(name = "payment_method", length = 255)
    private String paymentMethod;

    @Column(name = "status")
    private Integer status;

    @Column(name = "data", columnDefinition = "JSON")
    private String data;

    @Column(name = "created_by", length = 36)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
