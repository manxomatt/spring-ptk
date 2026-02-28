package com.ptk.application.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for product response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

    private String id;
    private String name;
    private String code;
    private String brandId;
    private String packtypeId;
    private Integer qty;
    private String nameToDisplay;
    private String cartonBarcode;
    private String cartonImage;
    private String pcsBarcode;
    private String pcsImage;
    private String status;
    private String image;
    private String category1Id;
    private String category2Id;
    private String category3Id;
    private String category4Id;
    private String flaggingSpecialStatus;
    private String description;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
