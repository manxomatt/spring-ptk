package com.ptk.application.dto.brand;

import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO for Brand responses.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandResponse {

    private String id;
    private String code;
    private String name;
    private String principalId;
    private String category1Id;
    private String category2Id;
    private String category3Id;
    private String category4Id;
    private String status;
    private Boolean integrated;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
