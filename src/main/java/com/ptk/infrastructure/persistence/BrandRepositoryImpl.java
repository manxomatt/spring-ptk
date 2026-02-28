package com.ptk.infrastructure.persistence;

import com.ptk.domain.model.brand.Brand;
import com.ptk.domain.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Implementation of BrandRepository using JPA.
 */
@Component
@RequiredArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {

    private final JpaBrandRepository jpaBrandRepository;

    @Override
    public Page<Brand> findAll(Pageable pageable) {
        return jpaBrandRepository.findAll(pageable);
    }

    @Override
    public Page<Brand> findAllActive(Pageable pageable) {
        return jpaBrandRepository.findAllActive(pageable);
    }

    @Override
    public Optional<Brand> findById(String id) {
        return jpaBrandRepository.findById(id);
    }

    @Override
    public Optional<Brand> findActiveById(String id) {
        return jpaBrandRepository.findActiveById(id);
    }

    @Override
    public Optional<Brand> findByCode(String code) {
        return jpaBrandRepository.findByCode(code);
    }

    @Override
    public Optional<Brand> findByName(String name) {
        return jpaBrandRepository.findByName(name);
    }

    @Override
    public Page<Brand> findByPrincipalId(String principalId, Pageable pageable) {
        return jpaBrandRepository.findByPrincipalId(principalId, pageable);
    }

    @Override
    public Page<Brand> searchByName(String keyword, Pageable pageable) {
        return jpaBrandRepository.searchByName(keyword, pageable);
    }

    @Override
    public Brand save(Brand brand) {
        return jpaBrandRepository.save(brand);
    }

    @Override
    public void deleteById(String id) {
        jpaBrandRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return jpaBrandRepository.existsById(id);
    }

    @Override
    public boolean existsByCode(String code) {
        return jpaBrandRepository.existsByCode(code);
    }

    @Override
    public boolean existsByName(String name) {
        return jpaBrandRepository.existsByName(name);
    }
}
