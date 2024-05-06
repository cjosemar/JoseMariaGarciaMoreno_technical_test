package org.example.inditex.infraestructure.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *Inditex General Exception Response.
 */
@Getter
@AllArgsConstructor
public class InditexResponseException {


    /**
     * Response status.
     */
    private int status;


    private String message;
}
