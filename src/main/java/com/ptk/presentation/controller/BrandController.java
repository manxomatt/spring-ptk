package com.ptk.presentation.controller;

import com.ptk.application.dto.brand.BrandRequest;
import com.ptk.application.dto.brand.BrandResponse;
import com.ptk.application.dto.common.ApiResponse;
import com.ptk.application.dto.common.PageResponse;
import com.ptk.application.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for Brand operations.
 */
@RestController
@RequestMapping("/v1/brands")
@RequiredArgsConstructor
@Tag(name = "Brand", description = "Brand management APIs")
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    @Operation(summary = "Get all brands", description = "Retrieve all active brands with pagination")
    public ResponseEntity<ApiResponse<PageResponse<BrandResponse>>> getAllBrands(
            @Parameter(description = "Page number (0-based)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size") @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Sort field") @RequestParam(defaultValue = "name") String sortBy,
            @Parameter(description = "Sort direction (asc/desc)") @RequestParam(defaultValue = "asc") String sortDir) {
        
        Sort sort = sortDir.equalsIgnoreCase("desc") 
                ? Sort.by(sortBy).descending() 
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<BrandResponse> brands = brandService.getAllBrands(pageable);
        PageResponse<BrandResponse> pageResponse = PageResponse.from(brands);
        
        return ResponseEntity.ok(ApiResponse.success(pageResponse, "Brands retrieved successfully"));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get brand by ID", description = "Retrieve a brand by its ID")
    public ResponseEntity<ApiResponse<BrandResponse>> getBrandById(
            @Parameter(description = "Brand ID") @PathVariable String id) {
        
        BrandResponse brand = brandService.getBrandById(id);
        return ResponseEntity.ok(ApiResponse.success(brand, "Brand retrieved successfully"));
    }

    @GetMapping("/code/{code}")
    @Operation(summary = "Get brand by code", description = "Retrieve a brand by its code")
    public ResponseEntity<ApiResponse<BrandResponse>> getBrandByCode(
            @Parameter(description = "Brand code") @PathVariable String code) {
        
        BrandResponse brand = brandService.getBrandByCode(code);
        return ResponseEntity.ok(ApiResponse.success(brand, "Brand retrieved successfully"));
    }

    @GetMapping("/principal/{principalId}")
    @Operation(summary = "Get brands by principal", description = "Retrieve brands by principal ID")
    public ResponseEntity<ApiResponse<PageResponse<BrandResponse>>> getBrandsByPrincipalId(
            @Parameter(description = "Principal ID") @PathVariable String principalId,
            @Parameter(description = "Page number (0-based)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size") @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        Page<BrandResponse> brands = brandService.getBrandsByPrincipalId(principalId, pageable);
        PageResponse<BrandResponse> pageResponse = PageResponse.from(brands);
        
        return ResponseEntity.ok(ApiResponse.success(pageResponse, "Brands retrieved successfully"));
    }

    @GetMapping("/search")
    @Operation(summary = "Search brands", description = "Search brands by name keyword")
    public ResponseEntity<ApiResponse<PageResponse<BrandResponse>>> searchBrands(
            @Parameter(description = "Search keyword") @RequestParam String keyword,
            @Parameter(description = "Page number (0-based)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size") @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        Page<BrandResponse> brands = brandService.searchBrandsByName(keyword, pageable);
        PageResponse<BrandResponse> pageResponse = PageResponse.from(brands);
        
        return ResponseEntity.ok(ApiResponse.success(pageResponse, "Brands retrieved successfully"));
    }

    @PostMapping
    @Operation(summary = "Create brand", description = "Create a new brand")
    public ResponseEntity<ApiResponse<BrandResponse>> createBrand(
            @Valid @RequestBody BrandRequest request) {
        
        BrandResponse brand = brandService.createBrand(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(brand, "Brand created successfully"));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update brand", description = "Update an existing brand")
    public ResponseEntity<ApiResponse<BrandResponse>> updateBrand(
            @Parameter(description = "Brand ID") @PathVariable String id,
            @Valid @RequestBody BrandRequest request) {
        
        BrandResponse brand = brandService.updateBrand(id, request);
        return ResponseEntity.ok(ApiResponse.success(brand, "Brand updated successfully"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete brand", description = "Soft delete a brand")
    public ResponseEntity<ApiResponse<Void>> deleteBrand(
            @Parameter(description = "Brand ID") @PathVariable String id) {
        
        brandService.deleteBrand(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Brand deleted successfully"));
    }
}
