package com.ptk.domain.model.warung;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * WarungSales domain entity.
 */
@Entity
@Table(name = "warung_sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarungSales implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "warung_id", length = 36)
    private String warungId;

    @Column(name = "product_id", length = 36)
    private String productId;

    @Column(name = "sales_order")
    private String salesOrder;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "qty")
    private Double qty;

    @Column(name = "price")
    private Double price;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "publish_at")
    private LocalDateTime publishAt;

    @Column(name = "publish_by", length = 36)
    private String publishBy;

    @Column(name = "sent_mail", nullable = false)
    private Boolean sentMail;

    @Column(name = "input_by", nullable = false, length = 36)
    private String inputBy;

    @Column(name = "updated_by", length = 36)
    private String updatedBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
