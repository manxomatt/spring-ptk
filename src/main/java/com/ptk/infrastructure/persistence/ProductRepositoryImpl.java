package com.ptk.infrastructure.persistence;

import com.ptk.domain.model.product.Product;
import com.ptk.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the domain ProductRepository interface.
 * Acts as an adapter between the domain layer and Spring Data JPA.
 */
@Component
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    @Override
    public Optional<Product> findById(String id) {
        return jpaProductRepository.findById(id);
    }

    @Override
    public Optional<Product> findByCode(String code) {
        return jpaProductRepository.findByCode(code);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll();
    }

    @Override
    public List<Product> findAllActive() {
        return jpaProductRepository.findAllActive();
    }

    @Override
    public List<Product> findByStatus(String status) {
        return jpaProductRepository.findByStatus(status);
    }

    @Override
    public List<Product> findByBrandId(String brandId) {
        return jpaProductRepository.findByBrandId(brandId);
    }

    @Override
    public List<Product> findByCategory1Id(String category1Id) {
        return jpaProductRepository.findByCategory1Id(category1Id);
    }

    @Override
    public Product save(Product product) {
        return jpaProductRepository.save(product);
    }

    @Override
    public void deleteById(String id) {
        jpaProductRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return jpaProductRepository.existsById(id);
    }

    @Override
    public boolean existsByCode(String code) {
        return jpaProductRepository.existsByCode(code);
    }
}
