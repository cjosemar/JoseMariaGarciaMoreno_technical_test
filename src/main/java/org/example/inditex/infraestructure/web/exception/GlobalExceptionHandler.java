package org.example.inditex.infraestructure.web.exception;

import org.example.inditex.domain.exception.InditexGeneralException;
import org.example.inditex.infraestructure.web.dto.InditexGeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * InditexGeneralException handler for REST services.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Response Exception {@link org.example.inditex.domain.exception.InditexGeneralException InditexGeneralException}.
     *
     * @param ex Exception.
     * @return Response
     */
    @ExceptionHandler(InditexGeneralException.class)
    public ResponseEntity<InditexGeneralResponse> handleNotFoundException(Exception ex) {
        InditexGeneralResponse error = new InditexGeneralResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Response Exception
     *
     * @return Response
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<InditexGeneralResponse> handleBadRequestException(Exception ex) {
        InditexGeneralResponse error = new InditexGeneralResponse(
                HttpStatus.BAD_REQUEST.value(),
                "## Your request has issued an incorrect or illegal request. ## \n" + ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
