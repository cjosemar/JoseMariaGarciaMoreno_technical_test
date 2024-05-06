package org.example.inditex.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Price Entity
 */
@Data
@Entity
@Table(name = "prices")
@IdClass(PriceKey.class)
public class PriceEntity {

    /**
     * Foreign key {@link org.example.inditex.domain.model.BrandEntity Brand}.
     */
    @Id
    @JoinColumn(name = "brand_id", nullable = false)
    @ManyToOne
    private BrandEntity brandEntity;

    /**
     * Beginning date range in which the indicated price rate applies.
     */
    @Id
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    /**
     * Final range of dates in which the indicated price rate applies.
     */
    @Id
    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    /**
     * Applicable pricing rate identifier
     */
    @Id
    @Column(name = "price_list")
    private int priceList;

    /**
     * Foreign key {@link org.example.inditex.domain.model.ProductEntity Product}.
     */
    @Id
    @JoinColumn(name = "product_id", nullable = false)
    @ManyToOne
    private ProductEntity productEntity;

    /**
     * Disambiguated from application of prices. If two rates coincide in a date range,
     * the one with the highest priority (highest numerical value) is applied.
     */
    @Column(name = "priority")
    private int priority;

    /**
     * Final sale price.
     */
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * Currency ISO.
     */
    @Column(name = "curr", length = 3)
    private String curr;

}
