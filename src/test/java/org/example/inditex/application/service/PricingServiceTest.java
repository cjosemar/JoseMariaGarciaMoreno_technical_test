package org.example.inditex.application.service;

import org.example.inditex.application.dto.PriceDto;
import org.example.inditex.domain.exception.InditexGeneralException;
import org.example.inditex.domain.model.BrandEntity;
import org.example.inditex.domain.model.PriceEntity;
import org.example.inditex.domain.model.ProductEntity;
import org.example.inditex.infraestructure.persistence.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PricingServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PricingService pricingService;

    private PriceEntity priceEntity;
    private PriceDto priceDtoExpected;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    @BeforeEach
    void setUp() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(1);
        brandEntity.setName("XYZ");

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(35455);
        productEntity.setName("Product Test");

        priceEntity = new PriceEntity();
        priceEntity.setBrandEntity(brandEntity);
        priceEntity.setStartDate(LocalDateTime.parse("2020-06-14-00.00.00", formatter));
        priceEntity.setEndDate(LocalDateTime.parse("2020-12-31-23.59.59", formatter));
        priceEntity.setPriceList(1);
        priceEntity.setProductEntity(productEntity);
        priceEntity.setPriority(1);
        priceEntity.setPrice(BigDecimal.valueOf(35.50));
        priceEntity.setCurr("EUR");

        priceDtoExpected = new PriceDto();
        priceDtoExpected.setBrandId(priceEntity.getBrandEntity().getId());
        priceDtoExpected.setStartDate(priceEntity.getStartDate());
        priceDtoExpected.setEndDate(priceEntity.getEndDate());
        priceDtoExpected.setPriceList(priceEntity.getPriceList());
        priceDtoExpected.setProductId(priceEntity.getProductEntity().getId());
        priceDtoExpected.setPrice(priceEntity.getPrice());
    }

    @Test
    @DisplayName("Test to verify that getPriceDetails returns a PriceDto correctly when there is valid data.")
    void getPriceDetailsSuccess() throws InditexGeneralException {
        when(priceRepository.getPriceDetails(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Collections.singletonList(priceEntity));

        when(modelMapper.map(any(PriceEntity.class), eq(PriceDto.class))).thenReturn(priceDtoExpected);

        PriceDto result = pricingService.getPriceDetails(LocalDateTime.parse("2020-06-14-10.00.00", formatter), 35455, 1);

        assertNotNull(result, "The result must not be null");
        assertEquals(priceDtoExpected, result, "The resulting DTO must match the expected data");
    }

    @Test
    @DisplayName("Test to verify that getPriceDetails throws InditexGeneralException when no data is found.")
    void getPriceDetailsNotFound() {
        when(priceRepository.getPriceDetails(any(LocalDateTime.class), anyInt(), anyInt()))
                .thenReturn(Collections.emptyList());

        assertThrows(InditexGeneralException.class, () ->
                        pricingService.getPriceDetails(LocalDateTime.parse("2020-06-14-10.00.00", formatter), 35455, 1),
                "Should throw an InditexGeneralException if there is no data");
    }

}