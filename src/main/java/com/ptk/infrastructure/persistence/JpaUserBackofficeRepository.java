package com.ptk.infrastructure.persistence;

import com.ptk.domain.model.user.UserBackoffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA Repository for UserBackoffice entity.
 */
@Repository
public interface JpaUserBackofficeRepository extends JpaRepository<UserBackoffice, String> {

    /**
     * Find user by username (active only).
     */
    @Query("SELECT u FROM UserBackoffice u WHERE u.username = :username AND u.deletedAt IS NULL")
    Optional<UserBackoffice> findByUsername(@Param("username") String username);

    /**
     * Find active user by ID.
     */
    @Query("SELECT u FROM UserBackoffice u WHERE u.id = :id AND u.deletedAt IS NULL")
    Optional<UserBackoffice> findActiveById(@Param("id") String id);

    /**
     * Check if username exists.
     */
    boolean existsByUsername(String username);
}
