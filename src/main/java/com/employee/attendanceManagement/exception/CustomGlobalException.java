package com.employee.attendanceManagement.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;
@ControllerAdvice
public class CustomGlobalException extends ResponseEntityExceptionHandler {


	 @Override
		protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
				HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	        CustomErrorDetail customErrorDetails = new CustomErrorDetail(
	                new Date(), HttpStatus.METHOD_NOT_ALLOWED.value(), "Method not supported");
	        return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);
	    }

	    @ExceptionHandler(ConstraintViolationException.class)
	    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
	                                                                           WebRequest request) {
	        CustomErrorDetail customErrorDetails = new CustomErrorDetail(
	                new Date(), HttpStatus.BAD_REQUEST.value(), "Validation Error");
	        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	    }

	    @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                HttpHeaders headers,
                HttpStatusCode status,
                WebRequest request)
 {
	        CustomErrorDetail customErrorDetails = new CustomErrorDetail(
	                new Date(), status.value(), "Validation Failed");
	        return new ResponseEntity<>(customErrorDetails, status);
	    }

	    @ExceptionHandler(UserNotFoundException.class)
	    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
	        CustomErrorDetail customErrorDetails = new CustomErrorDetail(
	                new Date(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
	        return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);
	    }
	    @ExceptionHandler(AssetNotFoundException.class)
	    public final ResponseEntity<Object> handleAssetNotFoundException(AssetNotFoundException ex, WebRequest request) {
	        CustomErrorDetail customErrorDetails = new CustomErrorDetail(
	                new Date(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
	        return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);
	    }
}