package org.example.inditex.infraestructure.persistence;

import org.example.inditex.domain.model.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Brand Repository
 */
@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {
}
