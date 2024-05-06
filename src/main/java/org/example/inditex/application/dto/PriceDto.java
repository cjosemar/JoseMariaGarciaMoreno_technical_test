package org.example.inditex.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO of {@link org.example.inditex.domain.model.PriceEntity PriceEntity}.
 */
@Getter
@Setter
public class PriceDto {

    /**
     * Brand Id
     */
    private int brandId;

    /**
     * Beginning date range in which the indicated price rate applies.
     */
    private LocalDateTime startDate;

    /**
     * Final range of dates in which the indicated price rate applies.
     */
    private LocalDateTime endDate;

    /**
     * Applicable pricing rate identifier
     */
    private int priceList;

    /**
     * Product Id
     */
    private int productId;

    /**
     * Final sale price.
     */
    private BigDecimal price;

}
