package com.ptk.presentation.controller;

import com.ptk.application.dto.common.ApiResponse;
import com.ptk.application.dto.product.ProductRequest;
import com.ptk.application.dto.product.ProductResponse;
import com.ptk.application.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for Product operations.
 */
@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Product management APIs")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieves a list of all products")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @GetMapping("/active")
    @Operation(summary = "Get all active products", description = "Retrieves a list of all active (non-deleted) products")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllActiveProducts() {
        List<ProductResponse> products = productService.getAllActiveProducts();
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Retrieves a product by its ID")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(
            @Parameter(description = "Product ID (UUID)") @PathVariable String id) {
        ProductResponse product = productService.getProductById(id);
        return ResponseEntity.ok(ApiResponse.success(product));
    }

    @GetMapping("/code/{code}")
    @Operation(summary = "Get product by code", description = "Retrieves a product by its code")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductByCode(
            @Parameter(description = "Product code") @PathVariable String code) {
        ProductResponse product = productService.getProductByCode(code);
        return ResponseEntity.ok(ApiResponse.success(product));
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Get products by status", description = "Retrieves products filtered by status")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getProductsByStatus(
            @Parameter(description = "Product status") @PathVariable String status) {
        List<ProductResponse> products = productService.getProductsByStatus(status);
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @GetMapping("/brand/{brandId}")
    @Operation(summary = "Get products by brand", description = "Retrieves products filtered by brand ID")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getProductsByBrandId(
            @Parameter(description = "Brand ID") @PathVariable String brandId) {
        List<ProductResponse> products = productService.getProductsByBrandId(brandId);
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get products by category", description = "Retrieves products filtered by category ID")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getProductsByCategory(
            @Parameter(description = "Category ID") @PathVariable String categoryId) {
        List<ProductResponse> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Creates a new product")
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(
            @Valid @RequestBody ProductRequest request) {
        ProductResponse product = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(product, "Product created successfully"));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Updates an existing product")
    public ResponseEntity<ApiResponse<ProductResponse>> updateProduct(
            @Parameter(description = "Product ID (UUID)") @PathVariable String id,
            @Valid @RequestBody ProductRequest request) {
        ProductResponse product = productService.updateProduct(id, request);
        return ResponseEntity.ok(ApiResponse.success(product, "Product updated successfully"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Soft deletes a product by its ID")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(
            @Parameter(description = "Product ID (UUID)") @PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Product deleted successfully"));
    }
}
