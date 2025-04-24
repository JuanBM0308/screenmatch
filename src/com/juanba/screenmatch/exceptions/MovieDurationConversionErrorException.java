package com.juanba.screenmatch.exceptions;

public class MovieDurationConversionErrorException extends RuntimeException {
    private String exceptionMessage;

    public MovieDurationConversionErrorException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String getMessage() {
        return this.exceptionMessage;
    }
}
