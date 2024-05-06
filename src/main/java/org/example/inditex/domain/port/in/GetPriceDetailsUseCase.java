package org.example.inditex.domain.port.in;

import org.example.inditex.application.dto.PriceDto;
import org.example.inditex.domain.exception.InditexGeneralException;

import java.time.LocalDateTime;

public interface GetPriceDetailsUseCase {

    /**
     * Retrieve price details for a given product and brand on a specific date.
     *
     * @param applicationDate The date and time of price application.
     * @param productId       The identifier of the product.
     * @param brandId         The identifier of the brand.
     * @return The {@link org.example.inditex.application.dto.PriceDto PriceDto} containing the price details.
     * @throws InditexGeneralException The {@link org.example.inditex.domain.exception.InditexGeneralException InditexGeneralException}
     */
    PriceDto getPriceDetails(LocalDateTime applicationDate, int productId, int brandId) throws InditexGeneralException;

}
