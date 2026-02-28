package com.ptk.domain.model.point;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * PointExchange domain entity.
 */
@Entity
@Table(name = "point_exchanges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PointExchange implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "motorist_id", nullable = false, length = 36)
    private String motoristId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "item_redeem", length = 36)
    private String itemRedeem;

    @Column(name = "shipping_info", columnDefinition = "TEXT")
    private String shippingInfo;

    @Column(name = "shipping")
    private Double shipping;

    @Column(name = "courier", length = 36)
    private String courier;

    @Column(name = "airwaybill", length = 50)
    private String airwaybill;

    @Column(name = "receiver_name", length = 100)
    private String receiverName;

    @Column(name = "receiver_phone", length = 50)
    private String receiverPhone;

    @Column(name = "receiver_address", columnDefinition = "TEXT")
    private String receiverAddress;

    @Column(name = "receiver_province", length = 36)
    private String receiverProvince;

    @Column(name = "receiver_city", length = 36)
    private String receiverCity;

    @Column(name = "receiver_district", length = 36)
    private String receiverDistrict;

    @Column(name = "receiver_subdistrict", length = 36)
    private String receiverSubdistrict;

    @Column(name = "receiver_zipcode", length = 6)
    private String receiverZipcode;

    @Column(name = "approved_by", length = 36)
    private String approvedBy;

    @Column(name = "rejected_by", length = 36)
    private String rejectedBy;

    @Column(name = "reasons", columnDefinition = "TEXT")
    private String reasons;

    @Column(name = "shipping_date")
    private LocalDateTime shippingDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", nullable = false, length = 36)
    private String updatedBy;
}
