package com.ptk.application.dto.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for creating or updating a product.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    @NotBlank(message = "Product name is required")
    @Size(max = 255, message = "Product name must not exceed 255 characters")
    private String name;

    @NotBlank(message = "Product code is required")
    @Size(max = 255, message = "Product code must not exceed 255 characters")
    private String code;

    @Size(max = 36, message = "Brand ID must not exceed 36 characters")
    private String brandId;

    @Size(max = 36, message = "Packtype ID must not exceed 36 characters")
    private String packtypeId;

    @Min(value = 0, message = "Quantity must be at least 0")
    private Integer qty;

    @Size(max = 255, message = "Name to display must not exceed 255 characters")
    private String nameToDisplay;

    @Size(max = 255, message = "Carton barcode must not exceed 255 characters")
    private String cartonBarcode;

    @Size(max = 255, message = "Carton image must not exceed 255 characters")
    private String cartonImage;

    @Size(max = 255, message = "PCS barcode must not exceed 255 characters")
    private String pcsBarcode;

    @Size(max = 255, message = "PCS image must not exceed 255 characters")
    private String pcsImage;

    @NotBlank(message = "Status is required")
    @Size(max = 255, message = "Status must not exceed 255 characters")
    private String status;

    @Size(max = 255, message = "Image must not exceed 255 characters")
    private String image;

    @Size(max = 36, message = "Category 1 ID must not exceed 36 characters")
    private String category1Id;

    @Size(max = 36, message = "Category 2 ID must not exceed 36 characters")
    private String category2Id;

    @Size(max = 36, message = "Category 3 ID must not exceed 36 characters")
    private String category3Id;

    @Size(max = 36, message = "Category 4 ID must not exceed 36 characters")
    private String category4Id;

    @Size(max = 255, message = "Flagging special status must not exceed 255 characters")
    private String flaggingSpecialStatus;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;
}
