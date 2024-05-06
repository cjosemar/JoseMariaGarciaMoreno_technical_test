package org.example.inditex.application.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO of {@link org.example.inditex.domain.model.BrandEntity BrandEntity}.
 */
@Getter
@Setter
public class BrandDto {

    /**
     * Brand Id
     */
    private int idBrand;

    /**
     * Brand name
     */
    private String nameBrand;

}
