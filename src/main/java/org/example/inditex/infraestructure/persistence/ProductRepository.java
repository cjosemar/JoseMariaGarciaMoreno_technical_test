package org.example.inditex.infraestructure.persistence;

import org.example.inditex.domain.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Product Repository
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
