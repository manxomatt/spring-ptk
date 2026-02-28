package com.ptk.infrastructure.persistence;

import com.ptk.domain.model.brand.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA Repository for Brand entity.
 */
@Repository
public interface JpaBrandRepository extends JpaRepository<Brand, String> {

    /**
     * Find all active brands (not soft-deleted).
     */
    @Query("SELECT b FROM Brand b WHERE b.deletedAt IS NULL")
    Page<Brand> findAllActive(Pageable pageable);

    /**
     * Find active brand by ID (not soft-deleted).
     */
    @Query("SELECT b FROM Brand b WHERE b.id = :id AND b.deletedAt IS NULL")
    Optional<Brand> findActiveById(@Param("id") String id);

    /**
     * Find brand by code.
     */
    Optional<Brand> findByCode(String code);

    /**
     * Find brand by name.
     */
    Optional<Brand> findByName(String name);

    /**
     * Find brands by principal ID.
     */
    @Query("SELECT b FROM Brand b WHERE b.principalId = :principalId AND b.deletedAt IS NULL")
    Page<Brand> findByPrincipalId(@Param("principalId") String principalId, Pageable pageable);

    /**
     * Search brands by name containing keyword.
     */
    @Query("SELECT b FROM Brand b WHERE b.name LIKE %:keyword% AND b.deletedAt IS NULL")
    Page<Brand> searchByName(@Param("keyword") String keyword, Pageable pageable);

    /**
     * Check if brand exists by code.
     */
    boolean existsByCode(String code);

    /**
     * Check if brand exists by name.
     */
    boolean existsByName(String name);
}
