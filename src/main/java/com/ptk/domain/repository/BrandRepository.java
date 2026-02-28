package com.ptk.domain.repository;

import com.ptk.domain.model.brand.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Repository interface for Brand domain operations.
 */
public interface BrandRepository {

    /**
     * Find all brands with pagination.
     */
    Page<Brand> findAll(Pageable pageable);

    /**
     * Find all active brands (not soft-deleted) with pagination.
     */
    Page<Brand> findAllActive(Pageable pageable);

    /**
     * Find brand by ID.
     */
    Optional<Brand> findById(String id);

    /**
     * Find active brand by ID (not soft-deleted).
     */
    Optional<Brand> findActiveById(String id);

    /**
     * Find brand by code.
     */
    Optional<Brand> findByCode(String code);

    /**
     * Find brand by name.
     */
    Optional<Brand> findByName(String name);

    /**
     * Find brands by principal ID with pagination.
     */
    Page<Brand> findByPrincipalId(String principalId, Pageable pageable);

    /**
     * Search brands by name containing keyword.
     */
    Page<Brand> searchByName(String keyword, Pageable pageable);

    /**
     * Save a brand.
     */
    Brand save(Brand brand);

    /**
     * Delete a brand by ID.
     */
    void deleteById(String id);

    /**
     * Check if brand exists by ID.
     */
    boolean existsById(String id);

    /**
     * Check if brand exists by code.
     */
    boolean existsByCode(String code);

    /**
     * Check if brand exists by name.
     */
    boolean existsByName(String name);
}
