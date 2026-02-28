package com.ptk.domain.repository;

import com.ptk.domain.model.product.Product;

import java.util.List;
import java.util.Optional;

/**
 * Domain repository interface for Product aggregate.
 * This interface defines the contract for product persistence operations.
 * Implementation is provided in the infrastructure layer.
 */
public interface ProductRepository {

    /**
     * Find a product by its ID.
     */
    Optional<Product> findById(String id);

    /**
     * Find a product by its code.
     */
    Optional<Product> findByCode(String code);

    /**
     * Find all products.
     */
    List<Product> findAll();

    /**
     * Find all active products (not deleted).
     */
    List<Product> findAllActive();

    /**
     * Find products by status.
     */
    List<Product> findByStatus(String status);

    /**
     * Find products by brand ID.
     */
    List<Product> findByBrandId(String brandId);

    /**
     * Find products by category.
     */
    List<Product> findByCategory1Id(String category1Id);

    /**
     * Save a product (create or update).
     */
    Product save(Product product);

    /**
     * Delete a product by its ID.
     */
    void deleteById(String id);

    /**
     * Check if a product exists by ID.
     */
    boolean existsById(String id);

    /**
     * Check if a product exists by code.
     */
    boolean existsByCode(String code);
}
