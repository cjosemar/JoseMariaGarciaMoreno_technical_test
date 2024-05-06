package org.example.inditex.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Primary Key Price Entity
 * {@link org.example.inditex.domain.model.PriceEntity PriceEntity}.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PriceKey implements Serializable {

    /**
     * Brand
     */
    private BrandEntity brandEntity;

    /**
     * Beginning date range in which the indicated price rate applies.
     */
    private LocalDateTime startDate;

    /**
     * Final range of dates in which the indicated price rate applies.
     */
    private LocalDateTime endDate;

    /**
     * Product
     */
    private ProductEntity productEntity;

    /**
     * Applicable pricing rate identifier
     */
    private int priceList;

}
