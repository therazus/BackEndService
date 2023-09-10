package com.WHotels.HotelMIS.utils;

import com.WHotels.HotelMIS.dto.common.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> customExceptionHandler(Exception ex) {
        ErrorResponse errorResponse = ErrorResponse.builder().errorMsg(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}
