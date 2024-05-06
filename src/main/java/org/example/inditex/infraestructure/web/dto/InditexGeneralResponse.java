package org.example.inditex.infraestructure.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Inditex General Exception Response.
 */
@Getter
@AllArgsConstructor
public class InditexGeneralResponse {

    /**
     * Response status.
     */
    private int status;

    /**
     * Exception message.
     */
    private String message;
}
