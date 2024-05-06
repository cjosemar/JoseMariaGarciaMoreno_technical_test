package org.example.inditex.infraestructure.persistence;

import org.example.inditex.domain.model.PriceEntity;
import org.example.inditex.domain.model.PriceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Price Repository
 */
@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, PriceKey> {

    /**
     * Prices of a product depending on the date and brand.
     *
     * @param date      Application date.
     * @param productId Id of the product.
     * @param brandID   Id of the brand.
     * @return {@link org.example.inditex.domain.model.PriceEntity PriceEntity}
     */
    @Query("SELECT p "
            + "FROM PriceEntity p "
            + "WHERE p.brandEntity.id = :brandId AND p.productEntity.id = :productId "
            + "AND :date BETWEEN p.startDate AND p.endDate "
            + "ORDER BY p.priority DESC")
    List<PriceEntity> getPriceDetails(@Param("date") LocalDateTime date, @Param("productId") int productId,
                                      @Param("brandId") int brandID);

}
