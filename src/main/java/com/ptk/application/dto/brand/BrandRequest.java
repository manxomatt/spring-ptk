package com.ptk.application.dto.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * DTO for Brand create/update requests.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandRequest {

    @NotBlank(message = "Code is required")
    @Size(max = 255, message = "Code must not exceed 255 characters")
    private String code;

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must not exceed 255 characters")
    private String name;

    @Size(max = 36, message = "Principal ID must not exceed 36 characters")
    private String principalId;

    @Size(max = 36, message = "Category 1 ID must not exceed 36 characters")
    private String category1Id;

    @Size(max = 36, message = "Category 2 ID must not exceed 36 characters")
    private String category2Id;

    @Size(max = 36, message = "Category 3 ID must not exceed 36 characters")
    private String category3Id;

    @Size(max = 36, message = "Category 4 ID must not exceed 36 characters")
    private String category4Id;

    @Size(max = 255, message = "Status must not exceed 255 characters")
    private String status;

    private Boolean integrated;
}
