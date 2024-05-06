package org.example.inditex.infraestructure.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.example.inditex.application.dto.PriceDto;
import org.example.inditex.domain.exception.InditexGeneralException;
import org.example.inditex.domain.port.in.GetPriceDetailsUseCase;
import org.example.inditex.infraestructure.web.dto.InditexGeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/prices")
public class PricingController {

    private final GetPriceDetailsUseCase getPriceDetailsUseCase;

    @Autowired
    public PricingController(GetPriceDetailsUseCase getPriceDetailsUseCase) {
        this.getPriceDetailsUseCase = getPriceDetailsUseCase;
    }

    /**
     * Retrieve price details for a given product and brand on a specific date.
     *
     * @param date      The date and time of price application.
     * @param productId The identifier of the product.
     * @param brandId   The identifier of the brand.
     * @return The {@link org.example.inditex.application.dto.PriceDto PriceDto} containing the price details.
     * @throws InditexGeneralException The {@link org.example.inditex.domain.exception.InditexGeneralException InditexGeneralException}
     */
    @Operation(summary = "Retrieve price details for a given product and brand on a specific date.")
    @GetMapping(value = "getPriceDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved price details",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PriceDto.class))}),
            @ApiResponse(responseCode = "400", description = "Request could not be fulfilled due to bad syntax",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = InditexGeneralResponse.class))})
    })
    public ResponseEntity<PriceDto> getPriceDetails(
            @Parameter(description = "Application Date. (yyyy-MM-dd HH:mm:ss)")
            @RequestParam(value = "date")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime  date,
            @Parameter(description = "Product Id")
            @RequestParam(value = "productId") int productId,
            @Parameter(description = "Brand Id")
            @RequestParam(value = "brandId") int brandId
    ) throws InditexGeneralException {
        log.info("### Pricing Controller - getPriceDetails");

        PriceDto priceDetails = getPriceDetailsUseCase.getPriceDetails(date, productId, brandId);
        return ResponseEntity.ok(priceDetails);

    }

}
