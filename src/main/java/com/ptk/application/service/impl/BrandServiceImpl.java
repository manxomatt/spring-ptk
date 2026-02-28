package com.ptk.application.service.impl;

import com.ptk.application.dto.brand.BrandRequest;
import com.ptk.application.dto.brand.BrandResponse;
import com.ptk.application.mapper.BrandMapper;
import com.ptk.application.service.BrandService;
import com.ptk.domain.exception.EntityNotFoundException;
import com.ptk.domain.model.brand.Brand;
import com.ptk.domain.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Implementation of BrandService.
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<BrandResponse> getAllBrands(Pageable pageable) {
        log.debug("Fetching all active brands with pagination: {}", pageable);
        return brandRepository.findAllActive(pageable)
                .map(brandMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public BrandResponse getBrandById(String id) {
        log.debug("Fetching brand by ID: {}", id);
        Brand brand = brandRepository.findActiveById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand", id));
        return brandMapper.toResponse(brand);
    }

    @Override
    @Transactional(readOnly = true)
    public BrandResponse getBrandByCode(String code) {
        log.debug("Fetching brand by code: {}", code);
        Brand brand = brandRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Brand with code '" + code + "' not found"));
        return brandMapper.toResponse(brand);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BrandResponse> getBrandsByPrincipalId(String principalId, Pageable pageable) {
        log.debug("Fetching brands by principal ID: {}", principalId);
        return brandRepository.findByPrincipalId(principalId, pageable)
                .map(brandMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BrandResponse> searchBrandsByName(String keyword, Pageable pageable) {
        log.debug("Searching brands by name keyword: {}", keyword);
        return brandRepository.searchByName(keyword, pageable)
                .map(brandMapper::toResponse);
    }

    @Override
    public BrandResponse createBrand(BrandRequest request) {
        log.debug("Creating new brand with code: {}", request.getCode());
        
        // Check for duplicate code
        if (brandRepository.existsByCode(request.getCode())) {
            throw new IllegalArgumentException("Brand with code '" + request.getCode() + "' already exists");
        }
        
        // Check for duplicate name
        if (brandRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Brand with name '" + request.getName() + "' already exists");
        }
        
        Brand brand = brandMapper.toEntity(request);
        brand.setId(UUID.randomUUID().toString());
        
        Brand savedBrand = brandRepository.save(brand);
        log.info("Created brand with ID: {}", savedBrand.getId());
        
        return brandMapper.toResponse(savedBrand);
    }

    @Override
    public BrandResponse updateBrand(String id, BrandRequest request) {
        log.debug("Updating brand with ID: {}", id);
        
        Brand existingBrand = brandRepository.findActiveById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand", id));
        
        // Check for duplicate code (excluding current brand)
        brandRepository.findByCode(request.getCode())
                .filter(b -> !b.getId().equals(id))
                .ifPresent(b -> {
                    throw new IllegalArgumentException("Brand with code '" + request.getCode() + "' already exists");
                });
        
        // Check for duplicate name (excluding current brand)
        brandRepository.findByName(request.getName())
                .filter(b -> !b.getId().equals(id))
                .ifPresent(b -> {
                    throw new IllegalArgumentException("Brand with name '" + request.getName() + "' already exists");
                });
        
        brandMapper.updateEntity(existingBrand, request);
        Brand updatedBrand = brandRepository.save(existingBrand);
        log.info("Updated brand with ID: {}", updatedBrand.getId());
        
        return brandMapper.toResponse(updatedBrand);
    }

    @Override
    public void deleteBrand(String id) {
        log.debug("Soft deleting brand with ID: {}", id);
        
        Brand brand = brandRepository.findActiveById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand", id));
        
        brand.setDeletedAt(LocalDateTime.now());
        brandRepository.save(brand);
        log.info("Soft deleted brand with ID: {}", id);
    }
}
