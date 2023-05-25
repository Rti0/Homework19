package com.example.homework19.ControllerAdvice;

import com.example.homework19.ApiException.ApiException;
import com.example.homework19.ApiResponse.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.zip.DataFormatException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> ApiException(ApiException e) {
        String massage = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(massage));
    }

    @ExceptionHandler(DataFormatException.class)
    public ResponseEntity<ApiResponse> DataFormatException(ApiException e) {
        String massage = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(massage));
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ApiResponse> ArithmeticException(ApiException e){
        String massage = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(massage));
    }
}
