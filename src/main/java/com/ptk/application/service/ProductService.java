package com.ptk.application.service;

import com.ptk.application.dto.product.ProductRequest;
import com.ptk.application.dto.product.ProductResponse;

import java.util.List;

/**
 * Application service interface for Product operations.
 */
public interface ProductService {

    /**
     * Get all products.
     */
    List<ProductResponse> getAllProducts();

    /**
     * Get all active products (not deleted).
     */
    List<ProductResponse> getAllActiveProducts();

    /**
     * Get a product by ID.
     */
    ProductResponse getProductById(String id);

    /**
     * Get a product by code.
     */
    ProductResponse getProductByCode(String code);

    /**
     * Get products by status.
     */
    List<ProductResponse> getProductsByStatus(String status);

    /**
     * Get products by brand ID.
     */
    List<ProductResponse> getProductsByBrandId(String brandId);

    /**
     * Get products by category.
     */
    List<ProductResponse> getProductsByCategory(String category1Id);

    /**
     * Create a new product.
     */
    ProductResponse createProduct(ProductRequest request);

    /**
     * Update an existing product.
     */
    ProductResponse updateProduct(String id, ProductRequest request);

    /**
     * Delete a product by ID (soft delete).
     */
    void deleteProduct(String id);
}
