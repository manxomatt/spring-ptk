package com.ptk.domain.model.coupon;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Coupon domain entity.
 */
@Entity
@Table(name = "coupons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "motorist_id", nullable = false, length = 36)
    private String motoristId;

    @Column(name = "promo_id", length = 36)
    private String promoId;

    @Column(name = "grosir_id", length = 36)
    private String grosirId;

    @Column(name = "coupon_no", length = 255)
    private String couponNo;

    @Column(name = "total_product")
    private Double totalProduct;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "total_save")
    private Double totalSave;

    @Column(name = "claim_grosir", nullable = false)
    private Double claimGrosir;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "reasons", columnDefinition = "TEXT")
    private String reasons;

    @Column(name = "promo_type", nullable = false)
    private Integer promoType;

    @Column(name = "publish_at")
    private LocalDateTime publishAt;

    @Column(name = "publish_by", length = 36)
    private String publishBy;

    @Column(name = "approved_at")
    private LocalDateTime approvedAt;

    @Column(name = "approved_by", length = 36)
    private String approvedBy;

    @Column(name = "rejected_at")
    private LocalDateTime rejectedAt;

    @Column(name = "rejected_by", length = 36)
    private String rejectedBy;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "checkout_time", nullable = false)
    private LocalDateTime checkoutTime;

    @Column(name = "redeemed_at")
    private LocalDateTime redeemedAt;

    @Column(name = "invoice_image", length = 255)
    private String invoiceImage;

    @Column(name = "succeeded_at")
    private LocalDateTime succeededAt;

    @Column(name = "succeeded_by", length = 36)
    private String succeededBy;

    @Column(name = "is_successful_from", length = 255)
    private String isSuccessfulFrom;

    @Column(name = "is_paid", length = 255)
    private String isPaid;

    @Column(name = "midtrans_id", length = 255)
    private String midtransId;

    @Column(name = "transaction_type", length = 255)
    private String transactionType;

    @Column(name = "transaction_status", length = 255)
    private String transactionStatus;

    @Column(name = "payment_type", length = 125)
    private String paymentType;

    @Column(name = "gross_amount")
    private Double grossAmount;

    @Column(name = "fraud_status", length = 125)
    private String fraudStatus;

    @Column(name = "do_id_bosnet", length = 125)
    private String doIdBosnet;

    @Column(name = "signature_key", length = 125)
    private String signatureKey;

    @Column(name = "biller_code", length = 125)
    private String billerCode;

    @Column(name = "bill_key", length = 125)
    private String billKey;

    @Column(name = "va_number", length = 125)
    private String vaNumber;

    @Column(name = "bank", length = 100)
    private String bank;

    @Column(name = "eci", length = 125)
    private String eci;

    @Column(name = "pdf_url", columnDefinition = "TEXT")
    private String pdfUrl;

    @Column(name = "snap_url", columnDefinition = "TEXT")
    private String snapUrl;

    @Column(name = "custom_fields", columnDefinition = "TEXT")
    private String customFields;

    @Column(name = "masked_card", length = 125)
    private String maskedCard;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "publish_type")
    private PublishType publishType;

    @Column(name = "sent_mail", nullable = false)
    private Integer sentMail;

    @Column(name = "is_delivery")
    private Boolean isDelivery;

    @Column(name = "longitude", length = 255)
    private String longitude;

    @Column(name = "latitude", length = 255)
    private String latitude;

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

    @Column(name = "zip_code")
    private Integer zipCode;

    @Column(name = "updated_by", length = 36)
    private String updatedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "updated_type")
    private UpdatedType updatedType;

    @Column(name = "is_valid")
    private Boolean isValid;

    @Column(name = "printed", columnDefinition = "JSON")
    private String printed;

    @Column(name = "created_by", length = 36)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum PublishType {
        staff, superadmin, admin
    }

    public enum UpdatedType {
        staff, superadmin, system
    }
}
