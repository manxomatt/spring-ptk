package com.ptk.application.service;

import com.ptk.application.dto.brand.BrandRequest;
import com.ptk.application.dto.brand.BrandResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service interface for Brand operations.
 */
public interface BrandService {

    /**
     * Get all active brands with pagination.
     */
    Page<BrandResponse> getAllBrands(Pageable pageable);

    /**
     * Get brand by ID.
     */
    BrandResponse getBrandById(String id);

    /**
     * Get brand by code.
     */
    BrandResponse getBrandByCode(String code);

    /**
     * Get brands by principal ID.
     */
    Page<BrandResponse> getBrandsByPrincipalId(String principalId, Pageable pageable);

    /**
     * Search brands by name.
     */
    Page<BrandResponse> searchBrandsByName(String keyword, Pageable pageable);

    /**
     * Create a new brand.
     */
    BrandResponse createBrand(BrandRequest request);

    /**
     * Update an existing brand.
     */
    BrandResponse updateBrand(String id, BrandRequest request);

    /**
     * Soft delete a brand.
     */
    void deleteBrand(String id);
}
