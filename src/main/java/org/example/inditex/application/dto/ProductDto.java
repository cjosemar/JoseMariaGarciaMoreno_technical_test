package org.example.inditex.application.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO of {@link org.example.inditex.domain.model.ProductEntity ProductEntity}.
 */
@Getter
@Setter
public class ProductDto {

    /**
     * Product Id
     */
    private int idProduct;

    /**
     * Product Name
     */
    private String nameProduct;

}
