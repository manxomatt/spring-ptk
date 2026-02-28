package com.ptk.application.service.impl;

import com.ptk.application.dto.product.ProductRequest;
import com.ptk.application.dto.product.ProductResponse;
import com.ptk.application.mapper.ProductMapper;
import com.ptk.application.service.ProductService;
import com.ptk.domain.exception.EntityNotFoundException;
import com.ptk.domain.model.product.Product;
import com.ptk.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of ProductService.
 * Handles business logic for product operations.
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAllProducts() {
        log.debug("Fetching all products");
        List<Product> products = productRepository.findAll();
        return productMapper.toResponseList(products);
    }

    @Override
    public List<ProductResponse> getAllActiveProducts() {
        log.debug("Fetching all active products");
        List<Product> products = productRepository.findAllActive();
        return productMapper.toResponseList(products);
    }

    @Override
    public ProductResponse getProductById(String id) {
        log.debug("Fetching product with id: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product", id));
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse getProductByCode(String code) {
        log.debug("Fetching product with code: {}", code);
        Product product = productRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Product", code));
        return productMapper.toResponse(product);
    }

    @Override
    public List<ProductResponse> getProductsByStatus(String status) {
        log.debug("Fetching products with status: {}", status);
        List<Product> products = productRepository.findByStatus(status);
        return productMapper.toResponseList(products);
    }

    @Override
    public List<ProductResponse> getProductsByBrandId(String brandId) {
        log.debug("Fetching products with brand ID: {}", brandId);
        List<Product> products = productRepository.findByBrandId(brandId);
        return productMapper.toResponseList(products);
    }

    @Override
    public List<ProductResponse> getProductsByCategory(String category1Id) {
        log.debug("Fetching products in category: {}", category1Id);
        List<Product> products = productRepository.findByCategory1Id(category1Id);
        return productMapper.toResponseList(products);
    }

    @Override
    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        log.debug("Creating new product: {}", request.getName());
        
        // Check if code already exists
        if (request.getCode() != null && productRepository.existsByCode(request.getCode())) {
            throw new IllegalArgumentException("Product with code '" + request.getCode() + "' already exists");
        }

        Product product = productMapper.toEntity(request);
        
        // Generate UUID for new product
        product.setId(UUID.randomUUID().toString());
        
        // Set default status if not provided
        if (product.getStatus() == null) {
            product.setStatus("active");
        }

        Product savedProduct = productRepository.save(product);
        log.info("Created product with id: {}", savedProduct.getId());
        
        return productMapper.toResponse(savedProduct);
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(String id, ProductRequest request) {
        log.debug("Updating product with id: {}", id);
        
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product", id));

        // Check if code is being changed and if new code already exists
        if (request.getCode() != null && !request.getCode().equals(existingProduct.getCode())) {
            if (productRepository.existsByCode(request.getCode())) {
                throw new IllegalArgumentException("Product with code '" + request.getCode() + "' already exists");
            }
        }

        productMapper.updateEntityFromRequest(request, existingProduct);
        Product updatedProduct = productRepository.save(existingProduct);
        log.info("Updated product with id: {}", updatedProduct.getId());
        
        return productMapper.toResponse(updatedProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(String id) {
        log.debug("Soft deleting product with id: {}", id);
        
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product", id));
        
        // Soft delete
        product.softDelete();
        productRepository.save(product);
        log.info("Soft deleted product with id: {}", id);
    }
}
