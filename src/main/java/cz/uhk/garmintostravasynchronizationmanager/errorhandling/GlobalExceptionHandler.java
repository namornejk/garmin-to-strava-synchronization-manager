package cz.uhk.garmintostravasynchronizationmanager.errorhandling;

import cz.uhk.garmintostravasynchronizationmanager.errorhandling.exceptions.InternalErrorException;
import cz.uhk.garmintostravasynchronizationmanager.errorhandling.exceptions.InvalidInputException;
import cz.uhk.garmintostravasynchronizationmanager.errorhandling.exceptions.UnauthorizedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvalidInputException.class})
    public ErrorResponse handleInvalidInputException(InvalidInputException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(value = {UnauthorizedException.class})
    public ErrorResponse handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED.value());
    }

    @ExceptionHandler(value = {InternalErrorException.class})
    public ErrorResponse handleBusinessException(InternalErrorException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(value = {Exception.class})
    public ErrorResponse handleException(Exception ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}


