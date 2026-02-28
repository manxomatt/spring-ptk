package com.ptk.infrastructure.persistence;

import com.ptk.domain.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for Product entity.
 * This is the infrastructure layer implementation of data access.
 */
@Repository
public interface JpaProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findByCode(String code);

    List<Product> findByStatus(String status);

    List<Product> findByBrandId(String brandId);

    List<Product> findByCategory1Id(String category1Id);

    @Query("SELECT p FROM Product p WHERE p.deletedAt IS NULL")
    List<Product> findAllActive();

    boolean existsByCode(String code);
}
