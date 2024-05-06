package org.example.inditex.application.service;

import lombok.extern.slf4j.Slf4j;
import org.example.inditex.application.dto.PriceDto;
import org.example.inditex.domain.exception.InditexGeneralException;
import org.example.inditex.domain.model.PriceEntity;
import org.example.inditex.domain.port.in.GetPriceDetailsUseCase;
import org.example.inditex.infraestructure.persistence.PriceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Prices service implementation.
 */
@Slf4j
@Service
public class PricingService implements GetPriceDetailsUseCase {

    /**
     * Text formatted for exception.
     */
    private static final String INFOEXCEPTION = "## There is no price for the parameters Date: %s, ProductId: %d, BrandId: %d. ##";

    private final PriceRepository priceRepository;
    private final ModelMapper modelMapper;

    /**
     * Automatically injects PriceRepository and ModelMapper instances
     *
     * @param priceRepository {@link org.example.inditex.infraestructure.persistence.PriceRepository PriceRepository}
     * @param modelMapper     ModelMapper
     */
    @Autowired
    public PricingService(PriceRepository priceRepository, ModelMapper modelMapper) {
        this.priceRepository = priceRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Retrieve price details for a given product and brand on a specific date.
     *
     * @param applicationDate The date and time of price application.
     * @param productId       The identifier of the product.
     * @param brandId         The identifier of the brand.
     * @return The {@link org.example.inditex.application.dto.PriceDto PriceDto} containing the price details.
     * @throws InditexGeneralException InditexGeneralException The {@link org.example.inditex.domain.exception.InditexGeneralException InditexGeneralException}
     */
    @Override
    public PriceDto getPriceDetails(LocalDateTime applicationDate, int productId, int brandId) throws InditexGeneralException {

        log.info("### Prices Services - getPriceDetails ###");


        List<PriceEntity> prices = priceRepository.getPriceDetails(applicationDate, productId, brandId);

        return modelMapper.map(prices.stream().findFirst().orElseThrow(() -> {
            String messageException = String.format(INFOEXCEPTION, applicationDate, productId, brandId);
            log.error(messageException);
            return new InditexGeneralException(messageException);
        }), PriceDto.class);

    }
}
