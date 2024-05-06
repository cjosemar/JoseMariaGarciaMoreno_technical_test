package org.example.inditex.domain.exception;

/**
 * Inditex General Exception.
 */
public class InditexGeneralException extends Exception {

    /**
     * Initiate a new general exception for Inditex.
     */
    public InditexGeneralException() {
        super();
    }

    /**
     * Initiate a new general exception for Inditex.
     *
     * @param message The message
     */
    public InditexGeneralException(String message) {
        super(message);
    }

}
